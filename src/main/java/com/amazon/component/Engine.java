package com.amazon.component;

import com.tesseraga.part.Part;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Named;

@Named
public class Engine implements Part {
    final Logger log = LoggerFactory.getLogger(Engine.class);

    public void run() {
        log.debug("Vroom Vroom");
    }

    @Override
    public String getDescription() {
        return "Basic Engine";
    }
}
