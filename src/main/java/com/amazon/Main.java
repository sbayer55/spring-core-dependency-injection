package com.amazon;

import com.amazon.common.CommonBean;
import com.amazon.common.CommonConfig;
import com.amazon.core.CoreBean;
import com.amazon.core.CoreConfig;
import com.amazon.plugins.grok.Grok;
import com.amazon.plugins.grok.GrokConfig;
import com.amazon.plugins.noop.NoOp;
import com.amazon.plugins.noop.NoOpConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void tryContext(AnnotationConfigApplicationContext context, String contextName) {

//        Arrays.stream(context.getBeanDefinitionNames()).forEach(name -> {
//            LOG.info("Context {} has bean definition {}", contextName, name);
//        });

        var beanTypes = List.of(CommonBean.class, CoreBean.class, Grok.class, NoOp.class);

        beanTypes.forEach(beanType -> {
            try {
                var bean = context.getBean(beanType);
                LOG.info("[X] In context {} bean Type {} is accessible", contextName, beanType);
            } catch (BeansException e) {
                LOG.warn("[ ] In context {} bean Type {} does not exist", contextName, beanType);
            }
        });
    }

    public static void main(String ... args) {
        LOG.trace("Creating context");

        var commonContext = new AnnotationConfigApplicationContext(CommonConfig.class);
        var coreContext = new AnnotationConfigApplicationContext(CoreConfig.class);
        var grokContext = new AnnotationConfigApplicationContext(GrokConfig.class);
        var noopContext = new AnnotationConfigApplicationContext(NoOpConfig.class);

        tryContext(commonContext, "commonContext");
        LOG.info("");
        tryContext(coreContext, "coreContext");
        LOG.info("");
        tryContext(grokContext, "grokContext");
        LOG.info("");
        tryContext(noopContext, "noopContext");
    }
}
