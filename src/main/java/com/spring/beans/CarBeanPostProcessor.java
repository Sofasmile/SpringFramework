package com.spring.beans;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class CarBeanPostProcessor implements BeanPostProcessor {
    private static final Logger LOG = Logger.getLogger(Car.class.getName());

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Car) {
            LOG.info("In postProcessAfterInitialization " + bean);
        }
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Car) {
            LOG.info("In postProcessBeforeInitialization " + bean);
        }
        return bean;
    }
}
