package org.javaboy.vhr.model.Enum;

import lombok.Data;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/10/16
 */

public enum RewardPunishEnum implements EnumCommonFactory {
    BE_LATE("迟到","BE_LATE",0),
    LEAVE_EARLY("早退","LEAVE_EARLY",0),
    CLOTHING_IMPROPRIETY("衣着不规范","CLOTHING_IMPROPRIETY",0),
    PLAY_PHONE_AT_WORK("上班玩手机","PLAY_PHONE_AT_WORK",0),

    PERFECT_ATTENDANCE("全勤","PERFECT_ATTENDANCE",1),
    OUTSTANDING_PERFORMANCE("业绩突出","OUTSTANDING_PERFORMANCE",1),
    GOOD_EMPLOYEES("优秀员工","GOOD_EMPLOYEES",1),
    INNOVATION("创新奖","INNOVATION",1);


    private String value;  //枚举value字段
    private String description; //枚举描述字段
    private int typeNum;//惩罚：0 奖励：1

    RewardPunishEnum(String description, String value, int typeNum) {
        this.description = description;
        this.value = value;
        this.typeNum = typeNum;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String getTypeName() {
        return description;
    }

    public int getTypeNum(){return typeNum;}
}
