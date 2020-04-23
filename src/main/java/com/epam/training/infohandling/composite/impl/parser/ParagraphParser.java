package com.epam.training.infohandling.composite.impl.parser;

import com.epam.training.infohandling.composite.TextParser;
import com.epam.training.infohandling.composite.TextComponent;
import com.epam.training.infohandling.composite.impl.TextComposite;


public class ParagraphParser implements TextParser {
    private static final String SENTENCE_REGULAR = "[.!?]+";
    private TextParser successor;

    public ParagraphParser(TextParser successor) {
        this.successor = successor;
    }

    public TextComponent parse(String text) {
        String[] strings = text.split(SENTENCE_REGULAR);
        TextComponent sentences = new TextComposite();
        TextParser successor = this.successor;
        for (String sentence : strings) {
            if (successor != null) {
                TextComponent words = successor.parse(sentence);
                sentences.addComponent(words);
            }
        }
        return sentences;
    }
}





