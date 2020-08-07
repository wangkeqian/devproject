package com.wkqian.synchronizedtypora.common;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/8/5
 */
public class ResultUtil {
    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
    public static Result error(Integer code, Object object) {
        Result result = new Result();
        result.setCode(code);
        result.setData(object);
        return result;
    }
    public static Result error(Integer code, String msg, Object object) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(object);
        return result;
    }
}
