package com.epam.training.infohandling.composite.impl;

import com.epam.training.infohandling.composite.TextParser;
import com.epam.training.infohandling.composite.impl.parser.ParagraphParser;
import com.epam.training.infohandling.composite.impl.parser.SentenceParser;
import com.epam.training.infohandling.composite.impl.parser.WordParser;

public class ChainCreator {
    public TextComposite createChain(String text) {
        TextParser charParser = new LetterLeaf(null);
        TextParser wordParser = new WordParser(charParser);
        TextParser sentenceParser = new SentenceParser(wordParser);
        TextParser paragraphParser = new ParagraphParser(sentenceParser);
        TextParser textParser = new com.epam.training.infohandling.composite.impl.parser.TextParser(paragraphParser);

        TextComposite composite = new TextComposite();
        composite.addComponent(textParser.parse(text));
        return composite;
    }
}
