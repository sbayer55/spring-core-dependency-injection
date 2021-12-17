package com.amazon.component;

import com.tesseraga.part.Part;

import javax.inject.Named;

@Named
public class Door implements Part {
    @Override
    public String getDescription() {
        return "A portal for accessing the interior of a car";
    }
}
