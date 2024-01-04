package com.example.helloworld.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class HelloService {
    public String getHello(String name) {
        validName(name);
        return "hello!! " + name;
    }

    public String getGoodBye(String name) {
        validName(name);
        return "good bye!! " + name;
    }

    private void validName(String name) {
        if (!StringUtils.hasText(name)) {
            throw new IllegalArgumentException("Empty Name");
        }
    }

}
