package com.amazon.component;

import com.tesseraga.part.Part;

import javax.inject.Named;

@Named
public class Breaks implements Part {

    @Override
    public String getDescription() {
        return "Breaks that will stop a car";
    }
}
