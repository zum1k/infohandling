package com.epam.training.infohandling.composite.impl;


import com.epam.training.infohandling.composite.ChainParser;
import com.epam.training.infohandling.composite.TextComponent;
import com.epam.training.infohandling.entity.LetterLeaf;
import com.epam.training.infohandling.entity.ParserType;
import com.epam.training.infohandling.entity.PunctuationLeaf;

public class ChainParserImpl implements ChainParser {
    private ParserType parserType;
    private ChainParser next;

    public ChainParserImpl(ParserType parserType, ChainParser next) {
        this.parserType = parserType;
        this.next = next;
    }

    public TextComponent parse(String text) {
        TextComposite composite = new TextComposite();
        if (next == null) {
            char[] letters = text.toCharArray();
            for (char letter : letters) {
                String c = String.valueOf(letter);
                if (c.matches(ParserType.LETTER.getRegExp())) {
                    composite.addComponent(new LetterLeaf(letter));
                } else {
                    composite.addComponent(new PunctuationLeaf(letter));
                }
            }
        } else {
            String[] matchers = text.split(parserType.getRegExp());
            for (String matcher : matchers) {
                composite.addComponent(next.parse(matcher));
            }
        }
        return composite;
    }
}
