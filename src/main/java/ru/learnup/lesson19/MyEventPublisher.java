package ru.learnup.lesson19;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyEventPublisher implements ApplicationContextAware {

    ApplicationContext context;

    public void publishEvent(String data) {
        context.publishEvent(new MyEvent(data));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
