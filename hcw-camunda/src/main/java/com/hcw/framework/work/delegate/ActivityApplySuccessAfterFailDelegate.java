package com.hcw.framework.work.delegate;


import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class ActivityApplySuccessAfterFailDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Object userId = delegateExecution.getVariable("userId");
        Object activityId = delegateExecution.getVariable("activityId");
        log.info("activityId:{},userId:{},活动报名成功后失败操作",activityId,userId);
    }
}
