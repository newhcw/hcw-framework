package com.hcw.framework.work.delegate;

import com.alibaba.fastjson.JSON;
import com.hcw.framework.work.response.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.engine.variable.value.ObjectValue;
import org.camunda.bpm.engine.variable.value.TypedValue;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserApplyFailDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Object userId = delegateExecution.getVariable("userId");
        Object activityId = delegateExecution.getVariable("activityId");
        log.info("activityId:{},userId:{},报名失败",activityId,userId);

        ObjectValue objectValue = Variables.objectValue(JSON.toJSONString(ResponseVo.builder().code(1000).message("报名失败").build()),true)
                .create();

        delegateExecution.setVariable("responseVo", objectValue);
    }
}
