package com.hcw.framework.work.service;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.repository.ProcessDefinition;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@Service
public class BpmnManagerService {

    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private RepositoryService repositoryService;

    private Map<String, ProcessDefinition> processDefinitionMap = new HashMap<>();

    public  ProcessInstance startProcess(String key,Map<String, Object> variables ) {
        return runtimeService.startProcessInstanceByKey(key,variables);
    }


    public boolean isExistProcessDefinitionByKey(String key){
        return processDefinitionMap.containsKey(key);
    }


    public void fillProcessDefinitionMap( ){
        List<ProcessDefinition> processDefinitionList = repositoryService.createProcessDefinitionQuery().active().latestVersion().list();
        for (ProcessDefinition pd : processDefinitionList) {
            processDefinitionMap.put(pd.getKey(),pd);
        }
    }
}
