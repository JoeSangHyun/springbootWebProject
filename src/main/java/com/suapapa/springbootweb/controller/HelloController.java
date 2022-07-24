package com.suapapa.springbootweb.controller;

import com.suapapa.springbootweb.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//1) 콘트롤러를 JSON을 반환하는 콘트롤러로 만들어준다.
@RestController
public class HelloController {
    //2) Http Method인 Get의 요청을 받을 수있는 API를 만들어준다.
    @GetMapping("/hello")
    public String hello() {
        return "hello suapapa";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount) {
        return new HelloResponseDto(name,amount);
    }
}