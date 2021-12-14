package com.bilitech.yilimusic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class DefaultController {

    @GetMapping
    public String sayHello() {
        return "欢迎程序猿依力的音乐盒";
    }
}
