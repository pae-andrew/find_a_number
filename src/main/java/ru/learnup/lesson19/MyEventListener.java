package ru.learnup.lesson19;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;

import java.util.Locale;

import static ru.learnup.lesson19.MyGame.x;
import static ru.learnup.lesson19.MyGame.locale;

@Slf4j
public class MyEventListener implements ApplicationListener<MyEvent>, ApplicationContextAware {
    ApplicationContext context;

    @Override
    public void onApplicationEvent(MyEvent event) {
        if (!Utils.isNumeric(event.getData())) {
            System.out.println(context.getMessage(event.getData(), null, locale));
        }
        else if (x == Integer.parseInt(event.getData())) {
            System.out.println(context.getMessage("win", new Object[]{event.getData()}, locale));
        }
        else if (x > Integer.parseInt(event.getData())) {
            System.out.println(context.getMessage("bigger", null, locale));
        }
        else {
            System.out.println(context.getMessage("less", null, locale));
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
