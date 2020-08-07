package com.wkqian.synchronizedtypora.controller;
import com.wkqian.synchronizedtypora.listenser.MyFileListener;
import com.wkqian.synchronizedtypora.service.FileMonitorService;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.io.*;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/7/4
 */
@Controller
public class FileMonitorApi {

    @Autowired
    FileMonitorService fileMonitorService;

    @GetMapping("start")
    public void index() throws Exception {
        fileMonitorService.startMonitoring();
    }

    @GetMapping("syncTypora")
    public void syncTypora(){
        fileMonitorService.sync();
    }
}
