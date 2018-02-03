package com.differenttaste.controller;

import com.differenttaste.bean.User;
import com.differenttaste.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = {"/user"})
public class UserController {

    @Autowired
    protected HttpServletRequest request;

    @Autowired
    private UserRepository userRepository;

    // login
    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public Object login(User user) {
        System.out.println(user.getName() + " - " + user.getPassword());
        user = userRepository.findByNameAndPassword(user.getName(), user.getPassword());
        if(null != user) {
            request.getSession().setAttribute("userName", user.getName());
            return true;
        } else {
            return false;
        }
    }

    // get current user name
    @RequestMapping(value = {"/validate"}, method = RequestMethod.GET)
    public Object validate() {
        return request.getSession().getAttribute("userName");
    }

}
