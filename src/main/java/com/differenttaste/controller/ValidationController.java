package com.differenttaste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
abstract public class ValidationController {

    @Autowired
    protected HttpServletRequest request;

    public boolean validateLogin(){
        String logged = (String) request.getSession().getAttribute("logged");
        if(null != logged) {
            return true;
        } else {
            return false;
        }
    }

}
