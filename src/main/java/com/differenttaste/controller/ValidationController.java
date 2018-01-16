package com.differenttaste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

@Controller
abstract public class ValidationController {

    @Autowired
    protected HttpServletRequest request;

    public String validateLogin(){
        String logged = (String) request.getSession().getAttribute("logged");
        if(null != logged) {
            return logged;
        } else {
            return "/index";
        }
    }

}
