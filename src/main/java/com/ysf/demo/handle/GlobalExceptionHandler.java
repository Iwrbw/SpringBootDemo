package com.ysf.demo.handle;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Create by yangshunfan
 * 2018/2/13 20:47
 */
@ControllerAdvice//控制增强
public class GlobalExceptionHandler {
    /**
     * 这里可以实现自己创建一个异常，然后异常在这里处理
     * 按照业务逻辑，其实每次都会对异常进行指定处理
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    private Map<String,Object> exceptionHandler(HttpServletRequest request,Exception e) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("success",false);
        map.put("errMsg",e.getMessage());
        return map;
    }

}
