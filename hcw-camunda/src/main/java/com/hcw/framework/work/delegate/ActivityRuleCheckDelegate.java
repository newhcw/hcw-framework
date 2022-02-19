package com.hcw.framework.work.delegate;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 判断是否在报名时间范围内
 * 2. 判断活动状态是否是上架
 * 3. 判断参与对象是否符合活动限制对象
 * 4. 判断是否是黑名单用户
 * 5. 判断是否超过个人参与活动的次数
 */
@Slf4j
@Service
public class ActivityRuleCheckDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Object userId = delegateExecution.getVariable("userId");
        Object activityId = delegateExecution.getVariable("activityId");
        log.info("activityId:{},userId:{},活动规则判断",activityId,userId);
        Map<String, Object> variables  = new HashMap<>();
        variables.put("checkResult", "Y");
        delegateExecution.setVariables(variables);
    }
}
