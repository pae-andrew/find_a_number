package ru.learnup.lesson19;

import org.springframework.context.ApplicationEvent;

public class MyEvent extends ApplicationEvent {

    private final String data;

    public MyEvent(Object source, String data) {
        super(source);
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
