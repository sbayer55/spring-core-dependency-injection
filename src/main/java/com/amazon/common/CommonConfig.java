package com.amazon.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Map;

@ComponentScan
public class CommonConfig {

    @Bean("GrokProperties")
    public BeanProperties grokBeanProperties() {
        return () -> null;
    }

    @Bean("NoOpProperties")
    public BeanProperties noOpBeanProperties() {
        return () -> Map.of("NoOp", "Nope");
    }
}
