package com.epam.training.infohandling.composite.impl.parser;

import com.epam.training.infohandling.composite.ChainParser;
import com.epam.training.infohandling.composite.TextComponent;
import com.epam.training.infohandling.composite.impl.TextComposite;
import com.epam.training.infohandling.composite.impl.LetterLeaf;

public class WordParser implements ChainParser {
    private static final String CHARACTER_REGULAR = "\\.";
    private ChainParser successor;

    public WordParser(ChainParser successor) {
        this.successor = successor;
    }

    public TextComponent parse(String text) {
        String[] strings = text.split(CHARACTER_REGULAR);
        TextComponent letters = new TextComposite();
        ChainParser successor = this.successor;
        for (String letter : strings) {
            if (successor != null) {
                TextComponent symbols = successor.parse(letter);
                letters.addComponent(symbols);
            }
            letters.addComponent(new LetterLeaf(letter.charAt(0)));
            // ili punctuation
        }
        return letters;
    }
}
