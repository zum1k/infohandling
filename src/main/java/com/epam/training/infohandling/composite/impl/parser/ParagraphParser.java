package com.epam.training.infohandling.composite.impl.parser;

import com.epam.training.infohandling.composite.ChainParser;
import com.epam.training.infohandling.composite.Component;
import com.epam.training.infohandling.composite.impl.Composite;


public class ParagraphParser implements ChainParser {
    private final static String SENTENCE_REGULAR = "[.!?]+";
    private ChainParser successor = null;

    public ParagraphParser(ChainParser child) {
        this.successor = child;
    }

    public Component parse(String text) {
        String[] strings = text.split(SENTENCE_REGULAR);
        Component sentences = new Composite();
        ChainParser successor = this.successor;
        for (String sentence : strings) {
            if (successor != null) {
                Component words = successor.parse(sentence);
                sentences.addComponent(words);
            }
        }
        return sentences;
    }
}





