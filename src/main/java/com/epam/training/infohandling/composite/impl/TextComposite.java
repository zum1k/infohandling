package com.epam.training.infohandling.composite.impl;

import com.epam.training.infohandling.composite.TextComponent;
import com.epam.training.infohandling.entity.ParserType;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {
    private static final String PARAGRAPH_DIVIDER = "  ";
    private ParserType type;
    private List<TextComponent> components = new ArrayList<>();

    public TextComposite() {
    }

    public TextComposite(ParserType type) {
        this.type = type;
    }

    @Override
    public ParserType getParserType() {
        return type;
    }

    @Override
    public void removeComponent(TextComponent component) {
        components.remove(component);
    }

    @Override
    public void addComponent(TextComponent component) {
        components.add(component);
    }

    @Override
    public List<TextComponent> getComponents() {
        return components;
    }

    public String toString() {
        StringBuilder resultString = new StringBuilder();
        for (TextComponent component : components) {
            switch (component.getParserType()) {
                case PARAGRAPH:
                    resultString.append(PARAGRAPH_DIVIDER);
                    break;
                case SENTENCE:
                case WORD:
                    resultString.append(" ");
                    break;
            }
            resultString.append(component.toString());
        }
        return resultString.toString().trim();
    }
}
