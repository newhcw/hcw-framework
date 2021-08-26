package cn.hcw.dubbo.provider.service;

import cn.hcw.dubbo.api.DemoService;
import cn.hcw.dubbo.api.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

@Slf4j
@DubboService(version = "1.0.0")
public class DefaultDemoService implements DemoService {
    @Override
    public User sayHi() throws InterruptedException {
        Thread.currentThread().sleep(1000);
        log.warn("a request is coming");
        User user = new User();
        user.setName("name");
        user.setSalary("18.0021");
        return user;
    }
}
