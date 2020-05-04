package com.epam.training.infohandling.composite.impl;


import com.epam.training.infohandling.composite.ChainParser;
import com.epam.training.infohandling.composite.TextComponent;
import com.epam.training.infohandling.entity.ParserType;

public class ChainParserImpl implements ChainParser {
    private ParserType parserType;
    private ParserType next;

    public ChainParserImpl(ParserType next) {
        this.next = next;
    }

    public TextComponent parse(String text) {
        TextComposite composite = new TextComposite();
        if(next == null){
            char[] letters = text.toCharArray();
            for(char letter: letters) {
                String c = String.valueOf(letter);
                if(c.matches(ParserType.LETTER.getRegExp())){
                    System.out.println("It's letter leaf " + c);
                }
                else {
                    System.out.println("It's punctuation leaf "+c);
                }

            }

            composite.addComponent(new LetterLeaf(text));
        }
        else{
            String[] matchers = text.split(textType.getRegExp());
            for (String matcher : matchers) {
                composite.add(next.event(matcher));
            }
        }
        return composite;
    }
}
