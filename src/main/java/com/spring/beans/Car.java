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

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Setter
@Getter
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@PropertySource({"classpath:spring/car.properties"})
public class Car implements Transport {
    private static Logger log = Logger.getLogger(Car.class.getName());

    @Value("${mileage}")
    private int mileage;

    @Value("${speed}")
    private int speed;

    @Value("${countOfWheels}")
    private int countOfWheels;

    @Autowired
    @Qualifier("winterWheel")
    private Wheel wheel;

    public Car() {

    }

    public Car(Wheel wheel, int countOfWheels, int speed, int mileage) {
        this.wheel = wheel;
        this.countOfWheels = countOfWheels;
        this.speed = speed;
        this.mileage = mileage;
    }

    @Override
    public void move() {
        wheel.diameter();
        log.info("There are " + countOfWheels + " wheels in the car");
        log.info("Speed in car is " + speed);
        log.info("Mileage in car is " + mileage + " km.");

    }

    @PostConstruct
    private void init() {
        log.info("Car is init!");
    }

    @PreDestroy
    private void preDestroy() {
        log.info("Car is destroy!");
    }
}
