package cn.hasfun.learn.springcloud.provider;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;


class HcwLearnSpringcloudOrderProviderApplicationTests {

    @Test
    void contextLoads() {
    }


    @Test
    void stopWatch() throws InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("test task a ");
        Thread.currentThread().sleep(1000*3);
        stopWatch.stop();


        stopWatch.start("test task b");
        Thread.currentThread().sleep(1000*4);
        stopWatch.stop();


        System.out.println(stopWatch.prettyPrint());
    }
}
