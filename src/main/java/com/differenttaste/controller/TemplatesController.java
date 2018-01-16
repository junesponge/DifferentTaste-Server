package com.differenttaste.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TemplatesController {

    // access index.html
    @RequestMapping(value = {"/index"}, method = RequestMethod.GET)
    public String index(HttpServletRequest request){
        request.setAttribute("key", "hello world");
        return "/index";
    }
}
