package com.spring.beans;

import lombok.Getter;
import lombok.Setter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
@PropertySource({"classpath:spring/bicycle.properties"})
public class Bicycle implements Transport {
    private static Logger log = Logger.getLogger(Car.class.getName());

    @Value("${speed}")
    private int speed;

    @Value("${countOfWheels}")
    private int countOfWheels;

    @Autowired
    @Qualifier("summerWheel")
    private Wheel wheel;

    public Bicycle() {

    }

    public Bicycle(Wheel wheel, int countOfWheels, int speed) {
        this.wheel = wheel;
        this.countOfWheels = countOfWheels;
        this.speed = speed;
    }

    @Override
    public void move() {
        wheel.diameter();
        log.info("There are " + countOfWheels + " wheels in the bicycle");
        log.info("Speed in bicycle is " + speed);
    }
}
