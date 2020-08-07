package com.wkqian.synchronizedtypora.model;

import lombok.Data;

import java.io.FileInputStream;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/8/4
 */
@Data
public class FileInfo {
    /*文件名字*/
    private String fileName;
    /*文件类型，包括img,video,html,preview_html等*/
    private String fileType;
    /*文件路径，用于提示文件服务器将文件存储到何种路径之下*/
    private String filePath;
    /*文件的输出流*/
    private FileInputStream inputStream;
    /*文件的大小*/
    private long fileSize;
}
