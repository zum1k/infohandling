package com.epam.training.infohandling.entity;

public enum Type {
    PARAGRAPH("Paragraph regular"),
    SENTENCE("Sentence regular"),
    WORD("Word regular"),
    LETTER("Letter regular"),
    PUNCTUATION("Punctuation regular");
     private String regExp;
     Type(String reg){
         this.regExp = reg;
     }
     public String getRegExp(){
         return regExp;
     }
}
