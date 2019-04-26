package com.spring.beans;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component("summerWheel")
public class SummerWheel implements Wheel {
    private static Logger log = Logger.getLogger(SummerWheel.class.getName());

    private static final int DIAMETER = 60;

    @Override
    public void diameter() {
        log.info("It is summer wheel with diameter: " + DIAMETER);
    }
}
