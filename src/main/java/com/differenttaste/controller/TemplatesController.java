package com.differenttaste.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TemplatesController extends ValidationController {

    // access index.html
    @RequestMapping(value = {"/index"}, method = RequestMethod.GET)
    public String index(HttpServletRequest request){
        return "/index";
    }

    // access main.html
    @RequestMapping(value = {"/main"}, method = RequestMethod.GET)
    public String main(HttpServletRequest request){
        if(validateLogin()) {
            return "/main";
        } else {
            return "/index";
        }
    }
}
