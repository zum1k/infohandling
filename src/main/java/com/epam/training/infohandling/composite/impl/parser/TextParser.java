package com.epam.training.infohandling.composite.impl.parser;

import com.epam.training.infohandling.composite.TextComponent;
import com.epam.training.infohandling.composite.impl.TextComposite;

public class TextParser implements com.epam.training.infohandling.composite.TextParser {
    private static final String PARAGRAPH_REGULAR = "\\s+\\n+";
    private com.epam.training.infohandling.composite.TextParser successor;

    public TextParser(com.epam.training.infohandling.composite.TextParser successor) {
        this.successor = successor;
    }

    public TextComponent parse(String text) {
        String[] strings = text.split(PARAGRAPH_REGULAR);
        TextComponent paragraphs = new TextComposite();
        com.epam.training.infohandling.composite.TextParser successor = this.successor;
        for (String paragraph : strings) {
            if (successor != null) {
                TextComponent sentences = successor.parse(paragraph);
                paragraphs.addComponent(sentences);
            }
        }
        return paragraphs;
    }
}
