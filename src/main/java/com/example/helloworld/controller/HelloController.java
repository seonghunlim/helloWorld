package com.example.helloworld.controller;

import com.example.helloworld.service.HelloService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final HelloService helloService;

    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        return helloService.getHello(name);
    }

    @GetMapping("/goodbye")
    public String goodbye(@RequestParam String name) {
        return helloService.getGoodBye(name);
    }
}
