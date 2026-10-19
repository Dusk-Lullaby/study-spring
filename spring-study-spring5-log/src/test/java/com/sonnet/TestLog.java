package com.sonnet;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLog {

    Logger logger = LoggerFactory.getLogger(TestLog.class);

    @Test
    public void test01() {
        logger.info("hello world");
    }
}
