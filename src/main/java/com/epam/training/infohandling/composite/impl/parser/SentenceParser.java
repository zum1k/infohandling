package com.epam.training.infohandling.composite.impl.parser;

import com.epam.training.infohandling.composite.ChainParser;
import com.epam.training.infohandling.composite.Component;
import com.epam.training.infohandling.composite.impl.Composite;

public class SentenceParser implements ChainParser {
    private final static String WORD_REGULAR = "\\s+";
    private ChainParser successor = null;

    public SentenceParser(ChainParser successor) {
        this.successor = successor;
    }

    public Component parse(String text) {
        String[] strings = text.split(WORD_REGULAR);
        Component words = new Composite();
        ChainParser successor = this.successor;
        for (String word : strings) {
            if(successor!=null) {
                Component letters = successor.parse(word);
                words.addComponent(letters);
            }
        }
        return words;
    }
}
