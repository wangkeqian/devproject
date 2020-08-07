package com.wkqian.synchronizedtypora.listenser;

import com.wkqian.synchronizedtypora.service.FileMonitorService;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Date;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/8/4
 */
@Component
public class MyFileListener extends FileAlterationListenerAdaptor{

    @Autowired
    FileMonitorService fileMonitorService;

    // 文件创建
    @Override
    public void onFileCreate(File file) {
        System.out.println("时间 : "+new Date() +" - 新建了"+ file.getName()+"文件");
        fileMonitorService.uploadTyporaFile(file);
    }

    @Override
    public void onFileChange(File file) {
        System.out.println("时间 : "+new Date() +" - "+ file.getName()+"文件修改了 onFileChange");
        fileMonitorService.uploadTyporaFile(file);
    }
}
