package com.springbootDemo.springbootDemo.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HelloControlller {

    @Value("${welcome.message}")
    private String welcomeMessage;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String helloWorld(){
        return welcomeMessage ;
    }
}
