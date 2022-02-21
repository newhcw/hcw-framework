package com.hcw.framework.work;



import com.hcw.framework.work.service.BpmnManagerService;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.repository.ProcessDefinition;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@EnableProcessApplication
@SpringBootApplication
public class ProcessApplication implements CommandLineRunner {

    Logger logger = LoggerFactory.getLogger(ProcessApplication.class);

    @Autowired
    private BpmnManagerService bpmnManagerService;




    public static void main(String... args) {
        SpringApplication.run(ProcessApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        bpmnManagerService.fillProcessDefinitionMap();
    }




}
