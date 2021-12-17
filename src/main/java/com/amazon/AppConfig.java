package com.amazon;

import com.tesseraga.part.Part;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.inject.Inject;

@Configuration
@ComponentScan(basePackageClasses = {com.amazon.Main.class})
@PropertySource("classpath:application.properties")
public class AppConfig {
    private static final Logger log = LoggerFactory.getLogger(AppConfig.class);

    @Bean
    public Part customPart() {
        log.trace("Creating Fuzzy Dice bean");
        return () -> "Fuzzy Dice, ooh yeah!";
    }

    @Inject
    public void loadBeanFromExternalClassPaths(
            @Value("${externalClasspaths}") String[] externalClassPaths,
            DefaultListableBeanFactory beanFactory
    ) {
        var componentProvider = new ClassPathScanningCandidateComponentProvider(true);

        for (var classpath : externalClassPaths) {
            log.info("Scanning classpath {}", classpath);
            var candidateComponents = componentProvider.findCandidateComponents(classpath);
            for (var candidate : candidateComponents) {
                var beanClassName = candidate.getBeanClassName();
                log.info("Should load bean? {}", candidate);
                beanFactory.registerBeanDefinition(beanClassName, candidate);
                log.info("Bean Loaded!");
            }
        }
    }
}
