package com.epam.training.infohandling.composite.impl.parser;

import com.epam.training.infohandling.composite.TextParser;
import com.epam.training.infohandling.composite.TextComponent;
import com.epam.training.infohandling.composite.impl.TextComposite;

public class SentenceParser implements TextParser {
    private static final String WORD_REGULAR = "\\s+";
    private TextParser successor = null;

    public SentenceParser(TextParser successor) {
        this.successor = successor;
    }

    public TextComponent parse(String text) {
        String[] strings = text.split(WORD_REGULAR);
        TextComponent words = new TextComposite();
        TextParser successor = this.successor;
        for (String word : strings) {
            if(successor!=null) {
                TextComponent letters = successor.parse(word);
                words.addComponent(letters);
            }
        }
        return words;
    }
}
