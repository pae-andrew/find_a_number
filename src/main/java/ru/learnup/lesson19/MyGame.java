package ru.learnup.lesson19;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Random;

public class MyGame {

    static Random random = new Random();
    public static int x = random.nextInt(0, 1000);
    public static Locale locale;
    public static int AttemptCounter = 0;

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("configuration.xml");
        MyEventPublisher publisher = context.getBean(MyEventPublisher.class);

        locale = Utils.setLocale();

        publisher.publishEvent("hello");
        publisher.publishEvent("start");

        boolean endGame = false;

        while (!endGame) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String answer = null;
            try {
                answer = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            assert answer != null;
            if (Utils.isNumeric(answer)) {
                publisher.publishEvent(answer);
                AttemptCounter++;
                if (Integer.parseInt(answer) == x) {endGame = true;}
            }
            else {
                publisher.publishEvent("notInt");
            }
        }
        publisher.publishEvent("countOfTry");
    }
}
