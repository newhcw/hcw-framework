package com.hcw.framework.work.delegate;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Slf4j
@Service
public class UserJoinedOtherEtfCheckDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Object userId = delegateExecution.getVariable("userId");
        Object activityId = delegateExecution.getVariable("activityId");
        log.info("activityId:{},userId:{},校验是否参加其他ETF大赛",activityId,userId);
        Map<String, Object> variables  = new HashMap<>();
        variables.put("repeatFlag", "N");
        delegateExecution.setVariables(variables);
    }
}
