package com.epam.training.infohandling.entity;

import com.epam.training.infohandling.composite.TextComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Objects;

public class PunctuationLeaf implements TextComponent {
    private static final Logger LOGGER = LogManager.getLogger(PunctuationLeaf.class);

    private ParserType type = ParserType.PUNCTUATION;
    private String value;
    private TextComponent successor = null;

    public PunctuationLeaf() {
    }

    public PunctuationLeaf(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PunctuationLeaf that = (PunctuationLeaf) o;
        return type == that.type &&
                Objects.equals(value, that.value) &&
                Objects.equals(successor, that.successor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, value, successor);
    }

    @Override
    public String toString() {
        return value;
    }
}
