package com.epam.training.infohandling.parser.impl;

import com.epam.training.infohandling.parser.Composite;
import com.epam.training.infohandling.parser.Handler;
import com.epam.training.infohandling.parser.Parser;

import java.util.ArrayList;
import java.util.List;

public class SentenceParser implements Handler, Parser, Composite {
    private final static String SENTENCE_REGULAR = "...";
    private WordParser child;
    private List<Parser> words = new ArrayList<Parser>();

    public SentenceParser(WordParser child) {
        this.child = child;
    }

    public SentenceParser() {
    }

    public String handleRequest() {
        return null;
    }

    public void add(Parser parser) {

    }

    public Parser getParser(int index) {
        return null;
    }

    public void remove(int index) {

    }

    public List<String> parse() {
        return null;
    }
}
