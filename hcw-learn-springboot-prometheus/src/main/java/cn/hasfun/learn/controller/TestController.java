package cn.hasfun.learn.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping(value = "/hello")
    public String sayHi() {
        return "hello";
    }
}
