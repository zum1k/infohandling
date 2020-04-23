package com.epam.training.infohandling.composite.impl;

import com.epam.training.infohandling.composite.TextComponent;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {
    private List<TextComponent> components = new ArrayList<TextComponent>();

    public void addComponent(TextComponent component) {
        components.add(component);
    }

    public List<TextComponent> getComponents() {
        return components;
    }
}
