package com.spring.beans;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class CarBeanPostProcessor implements BeanPostProcessor {
    private static Logger log = Logger.getLogger(Car.class.getName());

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Car) {
            log.info("In postProcessAfterInitialization " + bean);
        }
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Car) {
            log.info("In postProcessBeforeInitialization " + bean);
        }
        return bean;
    }
}
