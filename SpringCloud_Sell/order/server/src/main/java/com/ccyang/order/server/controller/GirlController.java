package com.ccyang.order.server.controller;

import com.ccyang.order.server.config.GirlConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ccyang
 * @date 2018/7/4 17:00
 */
@RestController
public class GirlController {

    @Autowired
    private GirlConfig girlConfig;

    @GetMapping("/girl/print")
    public String print(){
        return "name = " + girlConfig.getName() + " age = " + girlConfig.getAge();
    }
}
