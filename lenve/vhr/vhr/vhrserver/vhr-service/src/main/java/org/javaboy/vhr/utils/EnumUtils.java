package org.javaboy.vhr.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/10/16
 */
public class EnumUtils {
    /**
     * 枚举转map结合value作为map的key,description作为map的value
     *
     * @param enumT
     * @param methodNames
     * @return enum mapcolloction
     */
    public static <T> Map<Integer, List> EnumToMap(Class<T> enumT,
                                                    String... methodNames) {
        Map<Integer, List> enummap = new HashMap<>();

        if (!enumT.isEnum()) {
            return enummap;
        }
        T[] enums = enumT.getEnumConstants();
        if (enums == null || enums.length <= 0) {
            return enummap;
        }
        int count = methodNames.length;
        /**默认接口value方法*/
        String valueMathod = "getValue";
        /**默认接口typeName方法*/
        String desMathod = "getTypeName";
        /**默认接口typeNum方法*/
        String typeNum = "getTypeNum";
        /**扩展方法*/
        if (count >= 1 && !"".equals(methodNames[0])) {
            valueMathod = methodNames[0];
        }
        if (count == 2 && !"".equals(methodNames[1])) {
            desMathod = methodNames[1];
        }
        if (count == 3 && !"".equals(methodNames[2])) {
            typeNum = methodNames[2];
        }
        List<Map> zeroMaps = new ArrayList<>();
        List<Map> oneMaps = new ArrayList<>();
        for (int i = 0, len = enums.length; i < len; i++) {
            T tobj = enums[i];
            Map<Object, String> map = new HashMap<>();
            try {
                /**获取value值*/
                Object resultValue = getMethodValue(valueMathod, tobj);
                if ("".equals(resultValue)) {
                    continue;
                }
                /**获取typeName描述值*/
                Object resultDes = getMethodValue(desMathod, tobj);

                Integer num = (Integer) getMethodValue(typeNum, tobj);

                /**如果描述不存在获取属性值*/
                if ("".equals(resultDes)) {
                    resultDes = tobj;
                }
                map.put("value", resultValue +"");
                map.put("desc", resultDes + "");
                if (num == 0) zeroMaps.add(map);
                if (num == 1) oneMaps.add(map);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        enummap.put(0, zeroMaps);
        enummap.put(1, oneMaps);
        return enummap;
    }

    /**
     * 根据反射，通过方法名称获取方法值，忽略大小写的
     *
     * @param methodName
     * @param obj
     * @param args
     * @return return value
     */
    private static <T> Object getMethodValue(String methodName, T obj, Object... args) {
        Object resut = "";
        try {
            /********************************* start *****************************************/
            /**获取方法数组，这里只要共有的方法*/
            Method[] methods = obj.getClass().getMethods();
            if (methods.length <= 0) {
                return resut;
            }
            Method method = null;
            for (int i = 0, len = methods.length; i < len; i++) {
                /**忽略大小写取方法*/
                if (methods[i].getName().equalsIgnoreCase(methodName)) {
                    /**如果存在，则取出正确的方法名称*/
                    methodName = methods[i].getName();
                    method = methods[i];
                    break;
                }
            }
            /*************************** end ***********************************************/
            if (method == null) {
                return resut;
            }
            /**方法执行*/
            resut = method.invoke(obj, args);
            if (resut == null) {
                resut = "";
            }
            /**返回结果*/
            return resut;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resut;
    }

    /**
     * 通过value值获取对应的描述信息
     *
     * @param value
     * @param enumT
     * @param methodNames
     * @return enum description
     */
    public static <T> Object getEnumDescriotionByValue(Object value, Class<T> enumT, String... methodNames) {
        /**不是枚举则返回""*/
        if (!enumT.isEnum()) {
            return "";
        }
        /**获取枚举的所有枚举属性，似乎这几句也没啥用，一般既然用枚举，就一定会添加枚举属性*/
        T[] enums = enumT.getEnumConstants();
        if (enums == null || enums.length <= 0) {
            return "";
        }
        int count = methodNames.length;
        /**默认获取枚举value方法，与接口方法一致*/
        String valueMathod = "getValue";
        /**默认获取枚举getTypeName方法*/
        String desMathod = "getTypeName";
        if (count >= 1 && !"".equals(methodNames[0])) {
            valueMathod = methodNames[0];
        }
        if (count == 2 && !"".equals(methodNames[1])) {
            desMathod = methodNames[1];
        }
        for (int i = 0, len = enums.length; i < len; i++) {
            T t = enums[i];
            try {
                /**获取枚举对象value*/
                Object resultValue = getMethodValue(valueMathod, t);
                if (resultValue.toString().equals(value + "")) {
                    /**存在则返回对应描述*/
                    Object resultDes = getMethodValue(desMathod, t);
                    return resultDes;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    /**
     * 通过枚举value或者自定义值及方法获取枚举属性值
     *
     * @param value
     * @param enumT
     * @param methodNames
     * @return enum key
     */
    public static <T> String getEnumKeyByValue(Object value, Class<T> enumT, String... methodNames) {
        if (!enumT.isEnum()) {
            return "";
        }
        T[] enums = enumT.getEnumConstants();
        if (enums == null || enums.length <= 0) {
            return "";
        }
        int count = methodNames.length;
        /**默认方法*/
        String valueMathod = "getValue";
        /**独立方法*/
        if (count >= 1 && !"".equals(methodNames[0])) {
            valueMathod = methodNames[0];
        }
        for (int i = 0, len = enums.length; i < len; i++) {
            T tobj = enums[i];
            try {
                Object resultValue = getMethodValue(valueMathod, tobj);
                /**存在则返回对应值*/
                if (resultValue != null && resultValue.toString().equals(value + "")) {
                    return tobj + "";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    /**
     * 转换成List
     * @param enumT
     * @param methodNames
     * @return List<String>
     */
//    @SuppressWarnings({ "rawtypes", "unchecked" })
//    public static <T> List<String> getEnumToList(Class<T> enumT,String... methodNames){
//        Map<Object, String> map = EnumToMap(enumT);
//        List<String> result = new ArrayList(map.values());
//        return result;
//    }

}
