package com.hcw.framework.work.service;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class BpmnManagerService {

    @Autowired
    private RuntimeService runtimeService;

    public  ProcessInstance startProcess(String key) {
        return runtimeService.startProcessInstanceByKey(key);
    }


}
