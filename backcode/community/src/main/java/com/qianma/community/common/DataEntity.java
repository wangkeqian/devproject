package com.qianma.community.common;

import com.qianma.community.Model.User;
import com.qianma.community.utils.SystemUtil;
import lombok.Data;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/4/18
 */
@Data
public class DataEntity implements Serializable {
    private String id;
    private Date gmtCreate;
    private Date gmtModified;
    private String creator;
    private String updator;
    public String getId() {
        return id;
    }

    public Date getGmtCreate() {
        if (this.gmtCreate == null){
            this.gmtCreate = new Date();
        }
        return gmtCreate;
    }

    public Date getGmtModified() {
        if (this.gmtModified == null){
            this.gmtModified = new Date();
        }
        return gmtModified;
    }
    public void  setUUID(){
        if (null==id ||id.isEmpty()){
            this.id = UUID.randomUUID().toString();
        }
    }
}
