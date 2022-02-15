package com.hcw.framework.work.delegate;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserCheckApplyStatusService implements JavaDelegate {


    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Object userId = delegateExecution.getVariable("userId");
        Object activityId = delegateExecution.getVariable("activityId");
        log.info("校验activityId:{},userId:{}，报名状态",activityId,userId);

    }
}
