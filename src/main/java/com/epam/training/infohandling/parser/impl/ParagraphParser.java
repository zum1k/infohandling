package com.epam.training.infohandling.parser.impl;

import com.epam.training.infohandling.parser.Handler;
import com.epam.training.infohandling.parser.Composite;
import com.epam.training.infohandling.parser.Parser;

import java.util.ArrayList;
import java.util.List;

public class ParagraphParser implements Handler, Parser, Composite {
    private SentenceParser child;
    private List<Parser> sentences = new ArrayList<Parser>();

    public ParagraphParser(SentenceParser child) {
        this.child = child;
    }

    public String handleRequest() {
        return null;
    }

    public List<String> parse() {
        return null;
    }

    public void add(Parser parser) {

    }

    public Parser getParser(int index) {
        return null;
    }

    public void remove(int index) {

    }
}


