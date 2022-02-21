package com.hcw.framework.work.delegate;

import com.hcw.framework.work.service.BpmnManagerService;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RulerRouterDelegate implements JavaDelegate {

    @Autowired
    private BpmnManagerService bpmnManagerService;


    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String processKey = (String) delegateExecution.getVariable("processKey");
        if (bpmnManagerService.isExistProcessDefinitionByKey(processKey)){
            ProcessInstance processInstance = bpmnManagerService.startProcess(processKey);
        }else {
            throw new Exception("未定义流程");
        }

    }
}
