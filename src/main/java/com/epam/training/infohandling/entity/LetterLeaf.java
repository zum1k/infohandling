package com.epam.training.infohandling.entity;

import com.epam.training.infohandling.composite.ChainParser;
import com.epam.training.infohandling.composite.TextComponent;

import java.util.List;
import java.util.Objects;

public class LetterLeaf implements TextComponent, ChainParser {
    private ParserType type = ParserType.LETTER;
    private TextComponent successor = null;
    private char value;

    public LetterLeaf() {
    }

    public LetterLeaf(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    @Override
    public void addComponent(TextComponent component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<TextComponent> getComponents() {
        throw new UnsupportedOperationException();
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
    public TextComponent parse(String text) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LetterLeaf that = (LetterLeaf) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
