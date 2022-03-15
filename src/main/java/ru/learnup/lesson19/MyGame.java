package ru.learnup.lesson19;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyGame {

    private ApplicationContext context;

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("configuration.xml");
        MyEventPublisher publisher = context.getBean(MyEventPublisher.class);
        publisher.publishEvent("good boy");
    }
}
