package com.epam.training.infohandling.entity;

import com.epam.training.infohandling.composite.ChainParser;
import com.epam.training.infohandling.composite.TextComponent;

import java.util.List;

public class LetterLeaf implements TextComponent, ChainParser {
    private ParserType type = ParserType.LETTER;
    private TextComponent successor = null;
    private char value;

    public LetterLeaf(char value) {
        this.value = value;
    }

    public void addComponent(TextComponent component) {
    }

    public List<TextComponent> getComponents() {
        return null;
    }

    @Override
    public ParserType getParserType() {
        return null;
    }

    public TextComponent parse(String text) {
        return null;
    }

    public char getValue() {
        return value;
    }
}
