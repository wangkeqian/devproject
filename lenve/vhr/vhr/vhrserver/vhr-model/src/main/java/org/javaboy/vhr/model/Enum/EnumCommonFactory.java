package org.javaboy.vhr.model.Enum;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public interface EnumCommonFactory {
    String getValue();
    String getTypeName();
}
