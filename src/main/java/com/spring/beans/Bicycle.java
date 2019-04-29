package com.spring.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@NoArgsConstructor
@AllArgsConstructor
@PropertySource({"classpath:spring/bicycle.properties"})
public class Bicycle implements Transport {
    private final static Logger LOG = Logger.getLogger(Car.class.getName());

    @Value("${speed}")
    private int speed;

    @Value("${countOfWheels}")
    private int countOfWheels;

    @Autowired
    @Qualifier("summerWheel")
    private Wheel wheel;

    @Override
    public void move() {
        wheel.diameter();
        LOG.info("There are " + countOfWheels + " wheels in the bicycle");
        LOG.info("Speed in bicycle is " + speed);
    }
}
