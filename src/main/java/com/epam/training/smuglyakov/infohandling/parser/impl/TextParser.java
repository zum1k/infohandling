package com.epam.training.smuglyakov.infohandling.parser.impl;

import com.epam.training.smuglyakov.infohandling.parser.Action;
import com.epam.training.smuglyakov.infohandling.parser.Handler;
import com.epam.training.smuglyakov.infohandling.parser.Parser;


import java.util.ArrayList;
import java.util.List;

public class TextParser implements Handler, Parser, Action {
    private ParagraphParser child;
    private List<Parser> paragraphs = new ArrayList<Parser>();

    public TextParser(ParagraphParser child, List<Parser> paragraphs) {
        this.child = child;
        this.paragraphs = paragraphs;
    }

    public void add(Parser parser) {
        paragraphs.add(parser);
    }

    public Parser getParser(int index) {
        return paragraphs.get(index);
    }

    public void remove(int index) {
        paragraphs.remove(index);
    }

    public String handleRequest() {
        return null;
    }

    public List<String> parse() {
        return null;
    }
}
