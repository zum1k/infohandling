package com.epam.training.infohandling.action;

import com.epam.training.infohandling.composite.TextComponent;
import com.epam.training.infohandling.composite.impl.TextComposite;
import com.epam.training.infohandling.entity.ParserType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class TextAction {
    private static final Logger LOGGER = LogManager.getLogger(TextAction.class);

    public static void sortParagraphs(TextComposite composite, Comparator<TextComponent> comparator) {
        if(composite.getParserType()!= ParserType.TEXT){
            throw new UnsupportedOperationException("It's not TEXT parser type: " +composite.getParserType());
        }
        List<TextComponent> components = composite.getComponents();
        components.sort(comparator);
        LOGGER.info("Composite sorted by" + comparator.getClass());
    }

    public static Map<TextComponent, String> findSentencesWithLongestWord(TextComponent component) {
        int wordSize = 1;
        List<TextComponent> paragraphs = component.getComponents();
        List<TextComponent> allSentences = new ArrayList<>();

        for(TextComponent paragraph:paragraphs) {
            List<TextComponent> sentences = paragraph.getComponents();
            allSentences.addAll(sentences);
        }
        for(TextComponent sentence: allSentences){
            List<TextComponent> words = sentence.getComponents();
            for(TextComponent word: words){
                List<TextComponent> letters = word.getComponents();

            }
        }
    }

    public static List<TextComponent> removeSentencesBySize(TextComponent component, int sentenceSize) {

    }

    public static Map<TextComponent, Integer> findSimilarWords() {

    }
}
