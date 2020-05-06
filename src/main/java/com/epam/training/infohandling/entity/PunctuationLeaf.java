package com.epam.training.infohandling.entity;

import com.epam.training.infohandling.composite.TextComponent;

import java.util.List;

public class PunctuationLeaf implements TextComponent {
    private ParserType type = ParserType.PUNCTUATION;
    private char value;
    private TextComponent successor = null;

    public PunctuationLeaf() {
    }

    public PunctuationLeaf(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    @Override
    public ParserType getParserType() {
        return type;
    }

    @Override
    public void removeComponent(TextComponent component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void addComponent(TextComponent component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<TextComponent> getComponents() {
        throw new UnsupportedOperationException();
    }
}
