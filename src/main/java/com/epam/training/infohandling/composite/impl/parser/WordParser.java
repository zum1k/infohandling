package com.epam.training.infohandling.composite.impl.parser;

import com.epam.training.infohandling.composite.ChainParser;
import com.epam.training.infohandling.composite.Component;
import com.epam.training.infohandling.composite.impl.Composite;
import com.epam.training.infohandling.composite.impl.LetterLeaf;

public class WordParser implements ChainParser {
    private final static String CHARACTER_REGULAR = "\\.";
    private ChainParser successor;

    public WordParser(ChainParser child) {
        this.successor = child;
    }

    public Component parse(String text) {
        String[] strings = text.split(CHARACTER_REGULAR);
        Component letters = new Composite();
        ChainParser successor = this.successor;
        for (String letter : strings) {
            if (successor != null) {
                Component symbols = successor.parse(letter);
                letters.addComponent(symbols);
            }
            letters.addComponent(new LetterLeaf(letter.charAt(0)));
        }
        return letters;
    }
}
