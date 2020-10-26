package org.javaboy.vhr.model.Enum;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/10/17
 */
public enum RewPunEnum implements EnumCommonFactory {

    REWARD("奖励","REWARD",1),
    PUNISH("惩罚","PUNISH",0);

    private String value;  //枚举value字段
    private String description; //枚举描述字段

    RewPunEnum(String description,String value,int type) {
        this.value = value;
        this.description = description;
    }

    @Override
    public String getValue() {
        return String.valueOf(value);
    }

    @Override
    public String getTypeName() {
        return description;
    }
}
