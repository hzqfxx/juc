package com.juc.xx.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juc.xx.example.threadLock.RequestHolder;

@RestController
@RequestMapping("/threadLocal")
public class ThreadController {

    @GetMapping("/test")
    public Long test(){
        System.out.println(RequestHolder.get());
        return RequestHolder.get();
    }
}
