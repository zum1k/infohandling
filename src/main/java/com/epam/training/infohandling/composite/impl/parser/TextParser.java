package com.epam.training.infohandling.composite.impl.parser;

import com.epam.training.infohandling.composite.ChainParser;
import com.epam.training.infohandling.composite.Component;
import com.epam.training.infohandling.composite.impl.Composite;

public class TextParser implements ChainParser {
    private final static String PARAGRAPH_REGULAR = "\\s+\\n+";
    private ChainParser successor;

    public TextParser(ChainParser successor) {
        this.successor = successor;
    }

    public Component parse(String text) {
        String[] strings = text.split(PARAGRAPH_REGULAR);
        Component paragraphs = new Composite();
        ChainParser successor = this.successor;
        for (String paragraph : strings) {
            if (successor != null) {
                Component sentences = successor.parse(paragraph);
                paragraphs.addComponent(sentences);
            }
        }
        return paragraphs;
    }
}
