package com.wkqian.synchronizedtypora.model;

import com.wkqian.synchronizedtypora.common.DataEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/8/5
 */
@Data
public class SyncInfo extends DataEntity {
    /**
     * 执行/同步时间戳
     */
    private long syncTime;
    /**
     * IP地址
     */
    private String ipAddress;
    /**
     * 同步状态   成功/失败
     */
    private boolean syncStatus;
    /**
     * 同步状态   上传/下载
     */
    private String syncType;
    /**
     * 同步文件名称 （名称是唯一标识）
     */
    private String fileName;
    /**
     * 备注
     */
    private String desc;
}
