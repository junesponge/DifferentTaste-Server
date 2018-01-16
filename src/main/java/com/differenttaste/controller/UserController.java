package com.differenttaste.controller;

import com.differenttaste.bean.User;
import com.differenttaste.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController extends ValidationController {

    @Autowired
    private UserRepository userRepository;

    // login
    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public boolean login(User user) {
        System.out.println(user.getName() + " - " + user.getPassword());
        user = userRepository.findByNameAndPassword(user.getName(), user.getPassword());
        if(null != user) {
            request.getSession().setAttribute("logged", "logged");
            return true;
        } else {
            return false;
        }
    }

}
