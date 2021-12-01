package com.deimos.sdemails.webhandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.DispatcherHandler;

import javax.validation.constraints.NotNull;

@Component
public class LogWebHandlerPostProcessor implements BeanPostProcessor {
    private static final Logger log = LoggerFactory.getLogger(LogWebHandlerPostProcessor.class);

    @Override
    public Object postProcessBeforeInitialization(@NotNull Object bean, @NotNull String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(@NotNull Object bean, @NotNull String beanName) throws BeansException {
        if ("webHandler".equals(beanName) && bean instanceof DispatcherHandler) {
            log.info("begin to create log dispatcher handler");
            return new LogWebHandler((DispatcherHandler) bean);
        }
        return bean;
    }
}
