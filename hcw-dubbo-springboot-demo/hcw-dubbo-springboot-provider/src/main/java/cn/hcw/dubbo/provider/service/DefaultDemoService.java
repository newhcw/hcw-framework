package cn.hcw.dubbo.provider.service;

import cn.hcw.dubbo.api.DemoService;
import org.apache.dubbo.config.annotation.DubboService;


@DubboService
public class DefaultDemoService implements DemoService {
    @Override
    public String sayHi() {
        return "hello";
    }
}
