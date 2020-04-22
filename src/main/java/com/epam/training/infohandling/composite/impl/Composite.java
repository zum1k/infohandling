package com.epam.training.infohandling.composite.impl;

import com.epam.training.infohandling.composite.Component;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    private List<Component> components = new ArrayList<Component>();

    public void addComponent(Component component) {
        components.add(component);
    }

    public List<Component> getComponents() {
        return null;
    }
}
