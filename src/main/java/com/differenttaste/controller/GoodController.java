package com.differenttaste.controller;

import com.differenttaste.bean.Good;
import com.differenttaste.repository.GoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GoodController {

    @Autowired
    private GoodRepository goodRepository;

    // find all
    @RequestMapping(value = {"/findAll"}, method = RequestMethod.GET)
    public List<Good> findAll() {
        return goodRepository.findAll();
    }

    // find one
    @RequestMapping(value = {"/findOne"}, method = RequestMethod.GET)
    public Good findOne(@RequestParam("id") int id) {
        return goodRepository.findOne(id);
    }

    // add & update
    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public Good save(@RequestParam("good") Good good) {
        return goodRepository.save(good);
    }

    // delete
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public void delete(@RequestParam("good") Good good) {
        goodRepository.delete(good);
    }

}
