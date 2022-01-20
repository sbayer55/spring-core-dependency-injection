package com.amazon.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class CommonBean {
    private static final Logger LOG = LoggerFactory.getLogger(CommonBean.class);

    @Inject
    public CommonBean() {
    }

    public void print() {
        LOG.info("I'm a common bean");
    }
}
