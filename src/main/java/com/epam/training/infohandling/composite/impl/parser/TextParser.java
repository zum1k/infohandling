package com.epam.training.infohandling.composite.impl.parser;

import com.epam.training.infohandling.composite.ChainParser;
import com.epam.training.infohandling.composite.TextComponent;
import com.epam.training.infohandling.composite.impl.TextComposite;

public class TextParser implements ChainParser {
    private static final String PARAGRAPH_REGULAR = "\\s+\\n+";
    private ChainParser successor;

    public TextParser(ChainParser successor) {
        this.successor = successor;
    }

    public TextComponent parse(String text) {
        String[] strings = text.split(PARAGRAPH_REGULAR);
        TextComponent paragraphs = new TextComposite();
        ChainParser successor = this.successor;
        for (String paragraph : strings) {
            if (successor != null) {
                TextComponent sentences = successor.parse(paragraph);
                paragraphs.addComponent(sentences);
            }
        }
        return paragraphs;
    }
}
