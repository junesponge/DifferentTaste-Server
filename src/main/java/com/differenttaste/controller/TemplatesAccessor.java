package com.differenttaste.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = {"/index"})
public class TemplatesAccessor {

    // access index.html
    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    // access main.html
//    @RequestMapping(value = {"/main"}, method = RequestMethod.GET)
//    public String main(HttpServletRequest request){
//        return "/main";
//    }
}
