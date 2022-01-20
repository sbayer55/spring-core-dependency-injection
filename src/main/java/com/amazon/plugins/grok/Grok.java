package com.amazon.plugins.grok;

import com.amazon.common.BeanProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class Grok {
    private static final Logger LOG = LoggerFactory.getLogger(Grok.class);

    @Inject
    public Grok(@Named("GrokProperties") BeanProperties beanProperties) {
        assert beanProperties != null;
    }

    public void print() {
        LOG.info("Hello Grok");
    }
}
