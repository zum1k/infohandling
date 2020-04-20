package com.epam.training.infohandling.parser.impl;

import com.epam.training.infohandling.parser.Composite;
import com.epam.training.infohandling.parser.Handler;
import com.epam.training.infohandling.parser.Parser;

import java.util.ArrayList;
import java.util.List;

public class WordParser implements Handler, Parser, Composite {
    private LetterParser child;
    private List<Parser> letters = new ArrayList<Parser>();

    public WordParser(LetterParser child) {
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
