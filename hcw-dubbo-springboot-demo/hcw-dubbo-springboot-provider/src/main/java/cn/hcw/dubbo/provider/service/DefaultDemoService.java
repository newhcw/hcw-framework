package cn.hcw.dubbo.provider.service;

import cn.hcw.dubbo.api.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

@Slf4j
@DubboService(version = "1.0.0")
public class DefaultDemoService implements DemoService {
    @Override
    public String sayHi() throws InterruptedException {
        Thread.currentThread().sleep(1000);
        log.warn("a request is coming");
        return "hello";
    }
}
