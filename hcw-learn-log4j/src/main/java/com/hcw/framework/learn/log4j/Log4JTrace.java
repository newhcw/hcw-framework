package com.hcw.framework.learn.log4j;


import org.apache.log4j.LogManager;
 import org.apache.log4j.Logger;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

public class Log4JTrace {

    Logger logger = LogManager.getLogger(this.getClass());

//    Logger logger = LoggerFactory.getLogger(this.getClass());

    public void trace() {
        logger.info("log4j is logging");
    }







}
