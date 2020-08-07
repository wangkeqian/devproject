package com.qianma.community.utils;

import java.util.Arrays;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/5/1
 */
public class DtoToPo {
    /**
     * 将po对象的属性值赋值给dto对象相同属性名的属性
     * 此方法能将第一个转第二个无论是否DTO
     * @param po 赋值的对象
     * @param dto 被赋值的对象
     * @return
     * @throws Exception
     */
    public static Object poToDto(Object po, Object dto) throws Exception {
        Class poClass = po.getClass();
        Class dtoClass = dto.getClass();
        // 取得po对象的所有属性
        Field[] poFields = poClass.getDeclaredFields();
        //取父类的所有属性
        Field[] superPoFields = poClass.getSuperclass().getDeclaredFields();
        //合并数组
        poFields = (Field[]) mergeArray(poFields,superPoFields);

        // 遍历拼接dto的set方法字段表示
        for (Field f : poFields) {
            String fieldName = f.getName();
            //取得当前get，set字符串表达形式
            String dtoSetMethodName = "set" + firstToBig(fieldName);
            String poGetMethodName = "get"+firstToBig(fieldName);

            //System.out.println(fieldName + "=====" + dtoSetMethodName);
            // 取得DTO对象的set方法
            Method dtoSetMethod=null;
            try {
                dtoSetMethod = dtoClass.getMethod(dtoSetMethodName, f.getType());
            }catch (NoSuchMethodException e) {//如果不存在此方法跳过，
                continue;
            }
            //取得Po对象的get方法
            Method poGetMethod = poClass.getMethod(poGetMethodName, null);
            // 将po对象的属性值set到dto对象中去、
            dtoSetMethod.invoke(dto, poGetMethod.invoke(po, null));
        }
        return dto;

    }

    /**
     * 合并数组
     * @param a
     * @param b
     * @return
     */
    public static Object[] mergeArray(Object[] a,Object[] b) {
        Object[] c = Arrays.copyOf(a, a.length+b.length);
        System.arraycopy(b, 0, c, a.length, b.length);
        return c;
    }

    /**
     * 首字母大写
     *
     * @param fieldName
     * @return
     */
    public static String firstToBig(String fieldName) {
        if (fieldName != null && fieldName != "") {
            fieldName = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
        }
        return fieldName;
    }


}
