package com.epam.training.infohandling.entity;

public enum ParserType {
    TEXT("\\s{2}"),
    PARAGRAPH("[.!?]+\\s"),
    SENTENCE("\\s"),
    WORD("\\s"),
    LETTER("[a-zA-Zа-яА-Я0-9]+"),
    PUNCTUATION("[,.?!:;-)(]+");
    private String regExp;

    ParserType(String reg) {
        this.regExp = reg;
    }

    public String getRegExp() {
        return regExp;
    }
}
