package com.epam.training.infohandling.entity;

import com.epam.training.infohandling.composite.ChainParser;
import com.epam.training.infohandling.composite.TextComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Objects;


public class LetterLeaf implements TextComponent, ChainParser {
    private static final Logger LOGGER = LogManager.getLogger(LetterLeaf.class);

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
        LOGGER.error("Unsupported operation");
        throw new UnsupportedOperationException();
    }

    @Override
    public List<TextComponent> getComponents() {
        LOGGER.error("Unsupported operation");
        throw new UnsupportedOperationException();
    }

    @Override
    public ParserType getParserType() {
        return type;
    }

    @Override
    public void removeComponent(TextComponent component) {
        LOGGER.error("Unsupported operation");
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
        return Objects.hash(type, successor, value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
