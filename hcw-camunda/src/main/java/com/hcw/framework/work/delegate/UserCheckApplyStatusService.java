package com.hcw.framework.work.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class UserCheckApplyStatusService implements JavaDelegate {

    Logger logger = LoggerFactory.getLogger(UserCheckApplyStatusService.class);

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Object userId = delegateExecution.getVariable("userId");
        logger.info("校验userId:{}，报名状态",userId);

    }
}
