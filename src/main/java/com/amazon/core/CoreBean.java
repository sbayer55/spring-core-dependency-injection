package com.amazon.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class CoreBean {
    private static final Logger LOG = LoggerFactory.getLogger(CoreBean.class);

    @Inject
    public CoreBean() {
    }

    public void print() {
        LOG.info("I'm a core bean");
    }
}
