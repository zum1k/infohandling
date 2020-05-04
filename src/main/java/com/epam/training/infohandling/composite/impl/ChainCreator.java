package com.epam.training.infohandling.composite.impl;
import com.epam.training.infohandling.entity.ParserType;

public class ChainCreator {
    public TextComposite createChain(String text) {
        ChainParserImpl charLink = new ChainParserImpl(ParserType.LETTER, null);
        ChainParserImpl wordLink = new ChainParserImpl(ParserType.WORD, charLink);
        ChainParserImpl sentenceLink = new ChainParserImpl(ParserType.SENTENCE, wordLink);
        ChainParserImpl paragraphLink = new ChainParserImpl(ParserType.PARAGRAPH, sentenceLink);
        ChainParserImpl textLine = new ChainParserImpl(ParserType.TEXT, paragraphLink);

        TextComposite composite = new TextComposite();
        composite.addComponent(textLine.parse(text));
        return composite;
    }
}
