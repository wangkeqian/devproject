package org.javaboy.vhr.model.person;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.javaboy.vhr.model.Enum.RewPunEnum;
import org.javaboy.vhr.model.Enum.RewardPunishEnum;

import java.util.Date;

@Data
public class Employeeec {
    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "员工id")
    private Integer eid;

    @ApiModelProperty(value = "员工名字")
    private String employeeName;

    @ApiModelProperty(value = "奖惩日期")
    private Date ecdate;

    @ApiModelProperty(value = "奖惩类型")
    private RewPunEnum ectype;

    @ApiModelProperty(value = "奖惩原因")
    private RewardPunishEnum ecreason;

    @ApiModelProperty(value = "奖惩点数")
    private Integer ecpoint;

    @ApiModelProperty(value = "备注")
    private String remark;

    /*非数据库字段*/

    /*部门*/
    private String department;

    private Date startDate;

    private Date endDate;

    private Integer page = 1;

    private Integer size = 10;

}