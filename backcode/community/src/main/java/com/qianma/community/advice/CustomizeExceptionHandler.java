package com.qianma.community.advice;

import com.qianma.community.common.BaseController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 异常处理类
 *
 * @author wangkq
 * @date 2020/4/29
 */
@ControllerAdvice
public class CustomizeExceptionHandler extends BaseController {
    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    Map handle(HttpServletRequest request, Throwable wx) {
        HttpStatus status = getStatus(request);
        resultMap.setResultMap("STATE","EXCEPTION");
        resultMap.setResultMap("URL","/error/404");
        return resultMap.getInstance();
    }
    private HttpStatus getStatus(HttpServletRequest request){
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null ){
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}
