package com.epam.training.infohandling.parser.impl;

import com.epam.training.infohandling.parser.Handler;
import com.epam.training.infohandling.parser.Parser;

import java.util.List;

public class LetterParser implements Handler, Parser {
    private final static String LETTER_REGULAR = "...";
    private String value;
    private Parser child = null;

    public LetterParser(String value) {
        this.value = value;
    }

    public String handleRequest() {
        return null;
    }

    public List<String> parse() {
        return null;
    }

    public String getValue() {
        return value;
    }
}
