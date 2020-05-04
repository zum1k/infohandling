package com.epam.training.infohandling.composite.impl.parser;

import com.epam.training.infohandling.composite.ChainParser;
import com.epam.training.infohandling.composite.TextComponent;
import com.epam.training.infohandling.composite.impl.TextComposite;


public class ParagraphParser implements ChainParser {
    private static final String SENTENCE_REGULAR = "[.!?]+";
    private ChainParser successor;

    public ParagraphParser(ChainParser successor) {
        this.successor = successor;
    }
    ChainParser getSuccessor(){
        return successor;
   }
    public TextComponent parse(String text) {
        String[] strings = text.split(SENTENCE_REGULAR);
        TextComponent sentences = new TextComposite();
        ChainParser successor = this.successor;
        for (String sentence : strings) {
            if (successor != null) {
                TextComponent words = successor.parse(sentence);
                sentences.addComponent(words);
            }
        }
        return sentences;
    }
}





