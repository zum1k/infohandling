package com.epam.training.infohandling.entity;

import com.epam.training.infohandling.composite.TextComponent;

import java.util.List;

public class PunctuationLeaf implements TextComponent {
    private ParserType type = ParserType.PUNCTUATION;
    private char value;

    @Override
    public ParserType getParserType() {
        return type;
    }


    public PunctuationLeaf(char value) {
        this.value = value;
    }

    public void addComponent(TextComponent component) {
    }

    public List<TextComponent> getComponents() {
        return null;
    }
}
