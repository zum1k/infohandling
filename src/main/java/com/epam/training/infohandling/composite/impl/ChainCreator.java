package com.epam.training.infohandling.composite.impl;

import com.epam.training.infohandling.composite.ChainParser;
import com.epam.training.infohandling.composite.impl.parser.ParagraphParser;
import com.epam.training.infohandling.composite.impl.parser.SentenceParser;
import com.epam.training.infohandling.composite.impl.parser.TextParser;
import com.epam.training.infohandling.composite.impl.parser.WordParser;

public class ChainCreator {
    public ChainParser createChain(){
        ChainParser wordParser = new WordParser(null);
        ChainParser sentenceParser = new SentenceParser(wordParser);
        ChainParser paragraphParser = new ParagraphParser(sentenceParser);
        ChainParser textParser = new TextParser(paragraphParser);
        return textParser;
    };

}
