package com.amazon;

import com.amazon.fuel.FuelScan;
import com.tesseraga.part.Part;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import javax.inject.Named;
import java.util.List;

@Named
public class FuelScanScanner implements BeanFactoryPostProcessor {
    private static final Logger log = LoggerFactory.getLogger(FuelScanScanner.class);

    public FuelScanScanner() {
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        log.info("Updating Bean Factory");

        var factory = (DefaultListableBeanFactory) beanFactory;
        List.of("Muffler", "Drive Shaft", "Steering Wheel", "Shifter")
                .forEach(name -> factory.registerSingleton(name, (Part) () -> name));

        var scanner = new ClassPathScanningCandidateComponentProvider(false);
        scanner.addIncludeFilter(new AnnotationTypeFilter(FuelScan.class));

        log.debug("Scanning for Fuel Classes");
        var fuelClasses = scanner.findCandidateComponents("");
        log.debug("Found {} fuel classes", fuelClasses.size());

        fuelClasses.forEach(beanDefinition -> {
            String beanClassName = beanDefinition.getBeanClassName();
            log.debug("Candidate Fuel Class: {}", beanClassName);

            try {
                Class<?> beanClass = Class.forName(beanClassName);
                try {
                    Object bean = factory.getBean(beanClass);
                    log.debug("Bean already exists {}", bean);
                } catch (NoSuchBeanDefinitionException | BeanCreationException e) {
                    log.debug("Bean may have issues {}", beanClassName, e);

                    factory.registerBeanDefinition(beanClassName, beanDefinition);
                    log.debug("Created Bean {}", beanClassName);
                }
            } catch (ClassNotFoundException e) {
                log.error("Could not create bean {}", beanClassName, e);
            }
        });
    }
}
