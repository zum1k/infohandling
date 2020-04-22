package com.epam.training.infohandling.composite.impl;

import com.epam.training.infohandling.composite.ChainParser;
import com.epam.training.infohandling.composite.Component;

import java.util.List;

public class LetterLeaf implements Component, ChainParser {

    private Character value;
    private Component child = null;

    public LetterLeaf(Character value) {
        this.value = value;
    }

    public void addComponent(Component component) {
    }

    public List<Component> getComponents() {
        return null;
    }

    public Component parse(String text) {
        return null;
    }
}
