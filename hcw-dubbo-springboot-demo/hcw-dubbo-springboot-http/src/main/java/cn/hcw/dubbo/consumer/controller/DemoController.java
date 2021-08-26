package cn.hcw.dubbo.consumer.controller;

import cn.hcw.dubbo.api.DemoService;
import cn.hcw.dubbo.api.User;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/say")
public class DemoController {

   @DubboReference(version = "1.0.0",timeout = 30000)
    private DemoService demoService;


    @RequestMapping(value = "/hi")
    public User sayHi() throws InterruptedException {
        return demoService.sayHi();
    }
}
