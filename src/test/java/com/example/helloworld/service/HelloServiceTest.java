package com.example.helloworld.service;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloServiceTest {

    @Autowired
    private HelloService sut;

    @Test
    public void 성공_hello() {
        String name = "테스트이름";

        String result = sut.getHello(name);

        assertThat(result).startsWithIgnoringCase(" hello");
        assertThat(result).contains(name);
    }

    @Test
    public void 실패_hello() {
        String name = "";

        assertThatThrownBy(() -> sut.getHello(name)).hasMessageStartingWith("Empty");
    }

    @Test
    public void 성공_goodbye() {
        String name = "테스트이름";

        String result = sut.getGoodBye(name);

        assertThat(result).startsWithIgnoringCase("good bye");
        assertThat(result).contains(name);
    }

    @Test
    @DisplayName("이름이 빈문자열로 호출 시 실패한다")
    public void 실패_goodbye() {
        String name = "";

        assertThatThrownBy(() -> sut.getGoodBye(name)).hasMessageStartingWith("Empty");
    }
}