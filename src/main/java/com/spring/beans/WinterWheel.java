package com.spring.beans;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("winterWheel")
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class WinterWheel implements Wheel {
    private static Logger log = Logger.getLogger(WinterWheel.class.getName());
    private static final int DIAMETER = 50;

    @Override
    public void diameter() {
        log.info("It is winter wheel with diameter: " + DIAMETER);
    }
}
