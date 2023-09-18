package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping()
    public String hello() {
        return "hello";
    }

    @GetMapping("/a")
    public String a() {
        return "a";
    }

    @GetMapping("/b")
    public String b() {
        return "b";
    }
}
