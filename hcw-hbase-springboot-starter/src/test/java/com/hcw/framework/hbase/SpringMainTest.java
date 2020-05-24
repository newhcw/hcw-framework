package com.hcw.framework.hbase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringMainTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void save() {
        userRepository.save("huangchunwu", "951123033@qq.com", "12345");
    }

    @Test
    public void query(){
        System.out.println(userRepository.findAll());
    }

}