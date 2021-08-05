package cn.hcw.dubbo.consumer.controller;

import cn.hcw.dubbo.api.DemoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/say")
public class DemoController {

   @DubboReference(version = "1.0.0")
    private DemoService demoService;


    @RequestMapping(value = "/hi")
    public String sayHi() throws InterruptedException {
        return demoService.sayHi();
    }
}
