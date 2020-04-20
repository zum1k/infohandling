package com.epam.training.smuglyakov.infohandling.parser;

public interface Action {
    void add(Parser parser);
    Parser getParser(int index);
    void remove(int index);
}
