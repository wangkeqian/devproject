package com.wkqian.synchronizedtypora.quartz;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/8/4
 */
public class SyncTypora implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        String printTime = new SimpleDateFormat("yy-MM-dd HH-mm-ss").format(new Date());
        System.out.println(printTime+" - "+"启动定时任务。。。。。。每十秒执行一次，执行三次");
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        System.out.println(jobDataMap.get("level")+" - "+jobDataMap.get("job"));
    }
}
