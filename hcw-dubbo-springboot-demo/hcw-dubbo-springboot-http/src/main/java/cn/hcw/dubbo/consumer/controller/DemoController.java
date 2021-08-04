package cn.hcw.dubbo.consumer.controller;

import cn.hcw.dubbo.api.DemoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class DemoController {

    @DubboReference(version = "1.0.0")
    private DemoService demoService;


    @RequestMapping(value = "/hi")
    public String sayHi() {
        String s = demoService.sayHi();
        return s;
    }
}
