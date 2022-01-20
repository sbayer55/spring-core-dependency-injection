package com.amazon.plugins.noop;

import com.amazon.common.BeanProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class NoOp {
    private static final Logger LOG = LoggerFactory.getLogger(NoOp.class);

    @Inject
    public NoOp(@Named("NoOpProperties") BeanProperties beanProperties) {
        assert beanProperties.getProperties() != null;
        assert beanProperties.getProperties().containsKey("NoOp");
    }

    public void print() {
        LOG.info("Hello NoOp");
    }
}
