package com.epam.training.smuglyakov.infohandling.parser;

public interface Composite {
    void add(Parser parser);
    Parser getParser(int index);
    void remove(int index);
}
