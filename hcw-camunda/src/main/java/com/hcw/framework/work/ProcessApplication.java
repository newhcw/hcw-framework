package com.hcw.framework.work;



import com.hcw.framework.work.delegate.UserApplySuccessService;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.repository.ProcessDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
public class ProcessApplication implements CommandLineRunner {

    Logger logger = LoggerFactory.getLogger(ProcessApplication.class);

    @Autowired
    RepositoryService repositoryService;



    public static void main(String... args) {
        SpringApplication.run(ProcessApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<ProcessDefinition> processDefinitionList = repositoryService.createProcessDefinitionQuery().active().latestVersion().list();
        logger.info("> 处于激活状态的最新版本的流程定义数量: " + processDefinitionList.size());
        for (ProcessDefinition pd : processDefinitionList) {
            logger.info("\t ===> Process definition: " + pd.getKey() + " 版本：" + pd.getVersion());

        }
    }




}
