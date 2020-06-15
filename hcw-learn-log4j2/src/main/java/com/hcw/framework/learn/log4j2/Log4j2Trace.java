package com.hcw.framework.learn.log4j2;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4j2Trace {

    //private final static Logger logger = LogManager.getLogger(Log4j2Trace.class);
    Logger logger = LoggerFactory.getLogger(this.getClass());


    public void trace() {
        logger.info("log4j2 is logging");
    }

}
