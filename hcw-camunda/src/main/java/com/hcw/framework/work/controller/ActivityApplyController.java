package com.hcw.framework.work.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.rest.dto.task.TaskDto;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value = "/market/activity")
public class ActivityApplyController {


    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "/apply")
    public String apply(@RequestParam(value = "userId")String userId,
                        @RequestParam(value = "activityId")String activityId ){
        Map<String, Object> variables  = new HashMap<>();
        variables.put("userId", userId);
        variables.put("activityId", activityId);
        runtimeService.startProcessInstanceByKey("act_apply_main_process", variables);
        return "SUCCESS";
    }

    @RequestMapping(value = "/agree")
    public String agree(@RequestParam(value = "processInstanceId")String processInstanceId){
        List<Task> taskList = taskService.createTaskQuery().processInstanceId(processInstanceId).list();
        taskList.stream().forEach(task -> {
            taskService.complete(taskList.get(0).getId());
            taskService.createComment(taskList.get(0).getId(), processInstanceId, "提交流程");
        });
        return "SUCESS";
    }



}
