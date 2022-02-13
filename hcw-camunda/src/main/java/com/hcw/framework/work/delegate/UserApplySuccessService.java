package com.hcw.framework.work.delegate;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserApplySuccessService implements JavaDelegate {


    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Object userId = delegateExecution.getVariable("userId");
        log.info("userId:{},报名成功，发放奖励开始",userId);
    }
}
