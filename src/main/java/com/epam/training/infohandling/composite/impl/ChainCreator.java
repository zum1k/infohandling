package com.epam.training.infohandling.composite.impl;

import com.epam.training.infohandling.entity.ParserType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ChainCreator {
    private static final Logger LOGGER = LogManager.getLogger(ChainCreator.class);

    public TextComposite createChain(String text) {
        ChainParserImpl charLink = new ChainParserImpl(ParserType.LETTER, null);
        ChainParserImpl wordLink = new ChainParserImpl(ParserType.WORD, charLink);
        ChainParserImpl sentenceLink = new ChainParserImpl(ParserType.SENTENCE, wordLink);
        ChainParserImpl paragraphLink = new ChainParserImpl(ParserType.PARAGRAPH, sentenceLink);
        ChainParserImpl textLine = new ChainParserImpl(ParserType.TEXT, paragraphLink);

        TextComposite composite = new TextComposite(ParserType.TEXT);
        composite.addComponent(textLine.parse(text));
        LOGGER.info("Composite was build");
        return composite;
    }
}
