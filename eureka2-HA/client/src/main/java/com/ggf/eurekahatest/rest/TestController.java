package com.ggf.eurekahatest.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Descripton TODO
 * @Author: gqf
 * @create: 2019-08-01 13:10
 */
@RestController
public class TestController {


    @GetMapping("/testEurekaHa")
    public String testEureka(){
        return "SUCCESS";
    }
}
