package com.amazon.component;

import com.amazon.fuel.Fuel;
import com.tesseraga.part.Part;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class Car {
    private static final Logger log = LoggerFactory.getLogger(Car.class);

    private final Engine engine;
    private final List<Part> parts;
    private final List<Fuel> fuels;

    @Inject
    public Car(Engine engine, List<Part> parts, List<Fuel> fuels) {
        log.trace("Constructing Car Bean");

        this.engine = engine;
        this.parts = parts;
        this.fuels = fuels;
    }

    public void run() {
        engine.run();
    }

    public void inventory() {
        log.info("Car Inventory");
        log.info("=================================");
        log.info("Parts");
        parts.forEach(part -> {
            log.info("Car part type: {}, Description: {}", part.getClass().getName(), part.getDescription());
        });
        log.info("=================================");
        log.info("Fuels");
        fuels.forEach(fuel -> {
            log.info("Car fuel: {}", fuel);
        });
    }
}
