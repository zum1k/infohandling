package com.epam.training.infohandling.parser.impl;

import com.epam.training.infohandling.parser.Composite;
import com.epam.training.infohandling.parser.Handler;
import com.epam.training.infohandling.parser.Parser;

import java.util.ArrayList;
import java.util.List;

public class TextParser implements Handler, Parser, Composite {

    private ParagraphParser child;
    private List<Parser> paragraphs = new ArrayList<Parser>();

    public TextParser(ParagraphParser child) {
        this.child = child;
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
