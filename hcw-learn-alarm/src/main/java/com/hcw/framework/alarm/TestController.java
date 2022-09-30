package com.hcw.framework.alarm;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {

    @RequestMapping(value="/test")
    public String queyList() {
        log.info("queyList:{}"," total spend:788");
        return "true";
    }
}
