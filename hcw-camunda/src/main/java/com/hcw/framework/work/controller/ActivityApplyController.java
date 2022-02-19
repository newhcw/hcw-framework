package com.hcw.framework.work.controller;

import com.alibaba.fastjson.JSON;
import com.hcw.framework.work.response.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.rest.dto.task.TaskDto;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.runtime.ProcessInstanceWithVariables;
import org.camunda.bpm.engine.task.Task;
import org.camunda.bpm.engine.variable.VariableMap;
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
    public ResponseVo apply(@RequestParam(value = "userId")String userId,
                        @RequestParam(value = "activityId")String activityId ){
        Map<String, Object> variables  = new HashMap<>();
        variables.put("userId", userId);
        variables.put("activityId", activityId);
        ProcessInstanceWithVariables processInstanceWithVariables = runtimeService.createProcessInstanceByKey("act_apply_main_process").setVariables(variables).executeWithVariablesInReturn();
        VariableMap variablesMap = processInstanceWithVariables.getVariables();
        return JSON.parseObject((String) variablesMap.getOrDefault("responseVo", JSON.toJSONString(ResponseVo.builder().build())),ResponseVo.class);
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
