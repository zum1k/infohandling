package com.epam.training.infohandling.entity;

public enum ParserType {
    TEXT("//.+"),
    PARAGRAPH("//s{2}"),
    SENTENCE("[.!?]+//s"),
    WORD("//s"),
    LETTER("[a-zA-Zа-яА-Я]"),
    PUNCTUATION("[,.?!:;-]");
     private String regExp;
     ParserType(String reg){
         this.regExp = reg;
     }
     public String getRegExp(){
         return regExp;
     }
}
