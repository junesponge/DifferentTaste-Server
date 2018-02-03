package com.differenttaste.controller;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Aspect
@Component
@Controller
public class ValidationController {

    @Autowired
    protected HttpServletRequest request;

    static List<String> whiteList = new ArrayList<String>();

    static {
        whiteList.add("login");
    }

    // 需要加入切点的包.类.方法..
    @Around("execution(* com.differenttaste.controller.*Controller.*(..))")
    public Object validateLogin(ProceedingJoinPoint joinPoint) {
        Object userName = request.getSession().getAttribute("userName");
        String signature = joinPoint.getSignature().getName();
        System.out.println("Request path: " + signature);
        if(null != userName || whiteList.contains(signature)) {
            try {
                // 验证成功，直接返回目标方法的返回值
                return joinPoint.proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        } else {
            // 验证失败
            return null;
        }
        return null;
    }

}
