package com.hcw.learn.mybatis;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ResourceBanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.PrintStream;

@SpringBootApplication
@MapperScan("com.hcw.learn.mybatis.mapper")
public class SpringBootMybatisApplication {

    public static void main(String[] args) {
		SpringApplication.run(SpringBootMybatisApplication.class, args);
//		SpringApplication springApplication = new SpringApplication(SpringBootMybatisApplication.class);
//		springApplication.setBanner(new ResourceBanner("banner.txt"));
//		springApplication.setBannerMode(Banner.Mode.CONSOLE);
//		springApplication.run(args);
	}

	@Component
	 class ApplicationStartupRunner implements CommandLineRunner {
		protected final Log logger = LogFactory.getLog(getClass());

		@Override
		public void run(String... args) throws Exception {
			logger.info("ApplicationStartupRunner run method Started !!");
		}
	}
    
}