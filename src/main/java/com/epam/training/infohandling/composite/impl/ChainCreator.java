package com.epam.training.infohandling.composite.impl;

import com.epam.training.infohandling.composite.ChainParser;
import com.epam.training.infohandling.composite.impl.parser.ParagraphParser;
import com.epam.training.infohandling.composite.impl.parser.SentenceParser;
import com.epam.training.infohandling.composite.impl.parser.TextParser;
import com.epam.training.infohandling.composite.impl.parser.WordParser;

public class ChainCreator {
    public Composite createChain(String text) {
        ChainParser charParser = new LetterLeaf(null);
        ChainParser wordParser = new WordParser(charParser);
        ChainParser sentenceParser = new SentenceParser(wordParser);
        ChainParser paragraphParser = new ParagraphParser(sentenceParser);
        ChainParser textParser = new TextParser(paragraphParser);

        Composite composite = new Composite();
        composite.addComponent(textParser.parse(text));
        return composite;
    }
}
