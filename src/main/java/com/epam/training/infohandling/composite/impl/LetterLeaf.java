package com.epam.training.infohandling.composite.impl;

import com.epam.training.infohandling.composite.ChainParser;
import com.epam.training.infohandling.composite.TextComponent;
import com.epam.training.infohandling.entity.ParserType;

import java.util.List;

public class LetterLeaf implements TextComponent, ChainParser {
    public static final String REGULAR_EXPRESSION = "[a-zA-Z][а-яА-Я][-]?";

    private char value;
    private TextComponent successor = null;

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
    public char getValue(){
        return value;
    }
}
