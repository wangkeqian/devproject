package com.wkqian.synchronizedtypora.common;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/8/4
 */
public class LocalExecuteCommand {
    public static String exeCmd(String commandStr) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(new Date())+" - 执行： "+commandStr);
        String result = null;
        try {
            String[] cmd = new String[]{"/bin/sh", "-c",commandStr};
            Process ps = Runtime.getRuntime().exec(cmd);

            BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                //执行结果加上回车
                sb.append(line).append("\n");
            }
            result = sb.toString();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;

    }
}
