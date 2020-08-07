package com.wkqian.synchronizedtypora.service;

import com.wkqian.synchronizedtypora.common.LocalExecuteCommand;
import com.wkqian.synchronizedtypora.common.RemoteExecuteCommand;
import com.wkqian.synchronizedtypora.common.Result;
import com.wkqian.synchronizedtypora.common.ResultUtil;
import com.wkqian.synchronizedtypora.listenser.MyFileListener;
import com.wkqian.synchronizedtypora.quartz.SyncTypora;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.junit.Test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/8/4
 */
@Service
public class FileMonitorService {

    @Autowired
    MyFileListener myFileListener;
    @Autowired
    RemoteExecuteCommand rec;

    private final String HOSTNAME = "root@112.74.161.190:";
    private final String DEST_ADDRESS = "/opt/project/typora-file/";
    private final String DEFAULT_FILEPATH = "/Users/wangkeqian/Downloads/typoraFile/";

    //上传文件
    public Result uploadTyporaFile(File file){
        if (isHostConnectable()) {
            String cmd = "SCP " + DEFAULT_FILEPATH + file.getName() + " " + HOSTNAME + DEST_ADDRESS;
            String exeCmd = LocalExecuteCommand.exeCmd(cmd);
            System.out.println(exeCmd);
            return ResultUtil.success(file);
        }
        return ResultUtil.error(0,file);

    }
    //下拉文件
    public Result updateTyporaFile(String fileName){
        if (isHostConnectable()) {
            String cmd = "SCP " + HOSTNAME + DEST_ADDRESS + fileName + " " + DEFAULT_FILEPATH;
            LocalExecuteCommand.exeCmd(cmd);
            return ResultUtil.success(true);
        }
        return ResultUtil.success(false);
    }
    public void setQuartz() throws SchedulerException {
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        JobDetail jobDetail = JobBuilder.newJob(SyncTypora.class)
                .withDescription("this is a quartz")
                .withIdentity("job1", "group1")
                .usingJobData("level", "老")
                .build();
        JobDataMap jobDataMap = jobDetail.getJobDataMap();
        jobDataMap.put("job","司机");

        Trigger trigger = TriggerBuilder.newTrigger()
                .withDescription("this is a trigger")
//                .withSchedule(SimpleScheduleBuilder.repeatSecondlyForTotalCount(3, 10))
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0 6,12,18,24 * * ?"))
                .withIdentity("trigger1", "group1")
                .build();

        //将触发器调度任务详情绑定到scheduler上
        scheduler.scheduleJob(jobDetail,trigger);
        //start
        scheduler.start();
    }


    public Result startMonitoring() throws Exception {
        IOFileFilter filter = FileFilterUtils.or(FileFilterUtils.directoryFileFilter(), FileFilterUtils.fileFileFilter());
        FileAlterationObserver observer = new FileAlterationObserver(new File(DEFAULT_FILEPATH),filter);
        observer.addListener(myFileListener);
        FileAlterationMonitor monitor = new FileAlterationMonitor(2000, observer);// 创建文件变化监听器,间隔5秒
        monitor.start();// 开始监控
        return ResultUtil.success();
    }

    public void sync() {
        SimpleDateFormat df = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        Map remoteFileInfos = getFileInfos(DEST_ADDRESS,"remote");
        Map localFileInfos  = getFileInfos(DEFAULT_FILEPATH, "local");
        remoteFileInfos.forEach((k,v) ->{
            //如果本地时间小于服务器时间就下载最新的
            localFileInfos.forEach((kl,vl)->{
                if (kl.equals(k) && !vl.equals(v)){
                    try {
                        if (df.parse((String) vl).before(df.parse((String) v))){
                            System.out.println("发现有服务器有最新文件，即将下载");
                            updateTyporaFile((String) k);
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        });
    }
    @Test
    public  boolean isHostConnectable() {
        Socket socket = new Socket();
        String host = "112.74.161.190";
        int port = 22;
        try {
            socket.connect(new InetSocketAddress(host, port));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("ok");
        return true;
    }


    public Map getFileInfos(String dest,String type){
        String executeResult = "";
        if ("remote".equals(type)) {
            executeResult = rec.execute("ls "+dest+" -l --time-style +'%Y-%m-%d %H:%M:%S'" );
        }else if ("local".equals(type)){
            String cmd = "gls -l --time-style +'%Y-%m-%d %H:%M:%S' "+dest;
            executeResult = LocalExecuteCommand.exeCmd(cmd);
        }
        Map<String,Object> fileMap = new HashMap<>();
        String[] split = executeResult.split("\\r?\\n");
        List<String> remoteFileLists = Arrays.asList(split);
        remoteFileLists = remoteFileLists.stream().filter(e -> !e.contains("total")).collect(Collectors.toList());
        remoteFileLists.forEach(e ->{
            String[] info = e.split("\\s+");
            String modifiedDate = info[5]+" "+info[6];
            String fileName     = info[7];
            fileMap.put(fileName,modifiedDate);
        });
        return fileMap;
    }
}
