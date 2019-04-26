package com.spring;

import com.spring.beans.Bicycle;
import com.spring.beans.Car;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                new AnnotationConfigApplicationContext("com.spring.beans");

        Car firstCar = context.getBean(Car.class);
        System.out.println(firstCar.hashCode());
        System.out.println(firstCar.getWheel().hashCode());

        Car secondCar = context.getBean(Car.class);
        System.out.println(secondCar.hashCode());
        System.out.println(secondCar.getWheel().hashCode());

        Bicycle firstBicycle = context.getBean(Bicycle.class);
        System.out.println(firstBicycle.hashCode());
        System.out.println(firstBicycle.getWheel().hashCode());

        Bicycle secondBicycle = context.getBean(Bicycle.class);
        System.out.println(secondBicycle.hashCode());
        System.out.println(secondBicycle.getWheel().hashCode());
    }
}
