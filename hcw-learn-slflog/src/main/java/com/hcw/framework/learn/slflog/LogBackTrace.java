package com.hcw.framework.learn.slflog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogBackTrace {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public void trace() {
        logger.info("logback is logging");

    }


}
