package com.epam.training.infohandling.composite.impl;

import com.epam.training.infohandling.composite.ChainParser;
import com.epam.training.infohandling.composite.TextComponent;

import java.util.List;

public class LetterLeaf implements TextComponent, ChainParser {
    //dopisat

    private Character value;
    private TextComponent successor = null;

    public LetterLeaf(Character value) {
        this.value = value;
    }

    public void addComponent(TextComponent component) {
    }

    public List<TextComponent> getComponents() {
        return null;
    }

    public TextComponent parse(String text) {
        return null;
    }
}