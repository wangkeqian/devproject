package org.javaboy.vhr.model.searchParams;

import lombok.Data;

import java.util.Date;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/10/15
 */
@Data
public class PersonEcParams {
    private Integer id;

    private String employeeName;

    private Date startData;

    private Date endData;

    private String ecreason;

    private Integer ecpoint;

    private Integer ectype;

    private String remark;

}
