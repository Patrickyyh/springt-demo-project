package com.springbootDemo.springbootDemo.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HelloControlller {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String helloWorld(){
        return "Welcome to our first website aaaaaaeefefe";
    }
}
