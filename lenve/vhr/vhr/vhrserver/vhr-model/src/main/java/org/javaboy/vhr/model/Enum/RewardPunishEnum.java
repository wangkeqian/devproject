package org.javaboy.vhr.model.Enum;

import lombok.Data;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/10/16
 */

public enum RewardPunishEnum {
    BE_LATE("迟到","BE_LATE"),
    LEAVE_EARLY("早退","LEAVE_EARLY"),
    CLOTHING_IMPROPRIETY("衣着不规范","CLOTHING_IMPROPRIETY"),
    PLAY_PHONE_AT_WORK("上班玩手机","PLAY_PHONE_AT_WORK");
    RewardPunishEnum(String reason, String value) {
    }
    
}
