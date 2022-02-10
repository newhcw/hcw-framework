package com.hcw.framework.work.controller;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController("/market/activity")
public class ActivityApplyController {


    @Autowired
    private RuntimeService runtimeService;

    @RequestMapping(value = "/apply")
    public String apply(@RequestParam(value = "userId")String userId){
        Map<String, Object> variables  = new HashMap<>();
        variables.put("userId", userId);
        runtimeService.startProcessInstanceByKey("act_start",variables);
        return "SUCCESS";
    }

}
