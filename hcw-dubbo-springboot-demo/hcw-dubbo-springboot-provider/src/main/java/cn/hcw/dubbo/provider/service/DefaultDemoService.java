package cn.hcw.dubbo.provider.service;

import cn.hcw.dubbo.api.DemoService;
import org.apache.dubbo.config.annotation.DubboService;


@DubboService(version = "1.0.0")
public class DefaultDemoService implements DemoService {
    @Override
    public String sayHi() {
        return "hello";
    }
}
