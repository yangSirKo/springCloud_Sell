package com.ccyang.product.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用来测试与 order 服务的连接
 * @author ccyang
 * @date 2018/7/1 16:06
 */
@RestController
public class serverController {

    @GetMapping("/getMsg")
    public String getMsg(){
        return "this is product' msg2";
    }
}
