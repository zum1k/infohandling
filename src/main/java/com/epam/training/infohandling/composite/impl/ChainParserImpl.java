package com.epam.training.infohandling.composite.impl;

import com.epam.training.infohandling.composite.ChainParser;
import com.epam.training.infohandling.composite.TextComponent;
import com.epam.training.infohandling.entity.LetterLeaf;
import com.epam.training.infohandling.entity.ParserType;
import com.epam.training.infohandling.entity.PunctuationLeaf;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChainParserImpl implements ChainParser {

    private ParserType parserType;
    private ChainParserImpl next;

    ChainParserImpl(ParserType parserType, ChainParserImpl next) {
        this.parserType = parserType;
        this.next = next;
    }

    public TextComponent parse(String text) {
        text = text.trim();
        TextComponent composite = new TextComposite(parserType);
        if (next == null) {
            char[] letters = text.toCharArray();
            for (char letter : letters) {
                String c = String.valueOf(letter);
                if (c.matches(ParserType.LETTER.getRegExp())) {
                    composite.addComponent(new LetterLeaf(letter));
                } else {
                    composite.addComponent(new PunctuationLeaf(String.valueOf(letter)));
                }
            }
        } else {
            if (parserType == ParserType.PARAGRAPH) {
                List<String> punctuations = new ArrayList<>();
                Matcher m = Pattern.compile(parserType.getRegExp()).matcher(text);
                while (m.find()) {
                    punctuations.add(m.group());
                }
                String[] matchers = text.split(parserType.getRegExp());

                for (int n = 0; n < matchers.length; n++) {
                    composite.addComponent(next.parse(matchers[n]));
                    composite.addComponent(new PunctuationLeaf(punctuations.get(n)));
                }

            } else {
                String[] matchers = text.split(parserType.getRegExp());
                for (String matcher : matchers) {
                    composite.addComponent(next.parse(matcher));
                }
            }
        }
        return composite;
    }
}
