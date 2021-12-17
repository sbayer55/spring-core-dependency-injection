package com.amazon;

import com.amazon.component.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String ... args) {
        log.trace("Hello world");

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        log.trace("Context created");

        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(name -> log.debug("Bean Found: {}", name));

        Car car = context.getBean(Car.class);

        car.run();
        car.inventory();
    }
}
