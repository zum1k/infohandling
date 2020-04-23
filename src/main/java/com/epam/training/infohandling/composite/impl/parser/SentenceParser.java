package com.epam.training.infohandling.composite.impl.parser;

import com.epam.training.infohandling.composite.ChainParser;
import com.epam.training.infohandling.composite.TextComponent;
import com.epam.training.infohandling.composite.impl.TextComposite;

public class SentenceParser implements ChainParser {
    private static final String WORD_REGULAR = "\\s+";
    private ChainParser successor = null;

    public SentenceParser(ChainParser successor) {
        this.successor = successor;
    }
    ChainParser getSuccessor(){
        return successor;
    }

    public TextComponent parse(String text) {
        String[] strings = text.split(WORD_REGULAR);
        TextComponent words = new TextComposite();
        ChainParser successor = this.successor;
        for (String word : strings) {
            if(successor!=null) {
                TextComponent letters = successor.parse(word);
                words.addComponent(letters);
            }
        }
        return words;
    }
}
