package com.differenttaste.controller;

import com.differenttaste.bean.Cake;
import com.differenttaste.repository.CakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = {"/good"})
public class GoodController {

    @Autowired
    private CakeRepository cakeRepository;

    // find By Id Between
//    @RequestMapping(value = {"/findByIdBetween"}, method = RequestMethod.GET)
//    public List<Cake> findByIdBetween(@RequestParam(value = "from", required = true) int from, @RequestParam(value = "to", required = true) int to) {
//        System.out.println("from:" + from + " - to:" + to);
//        return cakeRepository.findByIdBetween(from, to);
//    }

    @RequestMapping(value = {"/findCakes"}, method = RequestMethod.GET)
    public List<Cake> findCakes() {
        return cakeRepository.findByChangeStatus("A");
    }

    // find one
    @RequestMapping(value = {"/findCake"}, method = RequestMethod.GET)
    public Cake findCake(@RequestParam("id") int id) {
        return cakeRepository.findOne(id);
    }

    // add & update
    @RequestMapping(value = "/saveCake", method = RequestMethod.GET)
    public Cake saveCake(@RequestParam("cake") Cake cake) {
        return cakeRepository.save(cake);
    }

    // delete
    @Transactional
    @RequestMapping(value = "/deleteCake", method = RequestMethod.DELETE)
    public boolean delete(Cake cake) {
        cake.setChangeStatus("D");
        cake.setChangeTime(new Date());
        try {
            if(cakeRepository.exists(cake.getId())) {
                cakeRepository.save(cake);
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // find all
    @RequestMapping(value = {"/findAll"}, method = RequestMethod.GET)
    public List<Cake> findAll() {
        return cakeRepository.findAll();
    }

}
