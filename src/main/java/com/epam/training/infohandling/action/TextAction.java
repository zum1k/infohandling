package com.epam.training.infohandling.action;

import com.epam.training.infohandling.composite.TextComponent;
import com.epam.training.infohandling.entity.ParserType;
import com.epam.training.infohandling.exception.TextActionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class TextAction {
    private static final Logger LOGGER = LogManager.getLogger(TextAction.class);

    public static TextComponent sortParagraphs(TextComponent component) throws TextActionException {
        if (component.getParserType() != ParserType.TEXT) {
            LOGGER.error("TextComponent type is not Text: " + component.getParserType().toString());
            throw new TextActionException("It's not TEXT parser type: " + component.getParserType().toString());
        }
        if (component.getComponents() == null) {
            LOGGER.error("TextComponent is null: " + component.getComponents());
            throw new TextActionException("Component is null: " + component.getComponents());
        }
        List<TextComponent> components = component.getComponents();
        for (TextComponent textComponent: components) {
            textComponent.getComponents().sort(Comparator.comparingInt(c -> c.getComponents().size()));
        }
        LOGGER.info("Composite sorted by");
        return component;
    }

    public static Map<TextComponent, String> findSentencesWithLongestWord(TextComponent component) throws TextActionException {
        if (component.getParserType() != ParserType.TEXT) {
            LOGGER.error("TextComponent type is not Text: " + component.getParserType().toString());
            throw new TextActionException("It's not TEXT parser type: " + component.getParserType().toString());
        }
        if (component.getComponents() == null) {
            LOGGER.error("TextComponent is null: " + component.getComponents());
            throw new TextActionException("Component is null: " + component.getComponents());
        }
        int wordSize = 0;
        Map<TextComponent, String> result = new HashMap<>();
        List<TextComponent> text = component.getComponents();
        List<TextComponent> allSentences = new ArrayList<>();

        for (TextComponent paragraphs : text) {
            List<TextComponent> sentences = paragraphs.getComponents();
            allSentences.addAll(sentences);
        }
        for (TextComponent sentence : allSentences) {
            List<TextComponent> words = sentence.getComponents();
            for (TextComponent word : words) {
                if (word.getParserType() == ParserType.PUNCTUATION) {
                    continue;
                }
                List<TextComponent> letters = word.getComponents();
                if (letters.size() > wordSize) {
                    result.clear();
                    result.put(sentence, letters.toString());
                    wordSize = letters.size();
                }
                if (letters.size() == wordSize) {
                    result.put(sentence, letters.toString());
                }
            }
        }
        LOGGER.info("Sentences was find by longest words");
        return result;
    }

    public static TextComponent removeSentencesBySize(TextComponent component, int sentenceSize) throws TextActionException {
        if (component.getParserType() != ParserType.TEXT) {
            LOGGER.error("TextComponent type is not Text: " + component.getParserType().toString());
            throw new TextActionException("It's not TEXT parser type: " + component.getParserType().toString());
        }
        if (component.getComponents() == null) {
            LOGGER.error("TextComponent is null: " + component.getComponents());
            throw new TextActionException("Component is null: " + component.getComponents());
        }
        List<TextComponent> text = component.getComponents();
        for (TextComponent textElement : text) {
            List<TextComponent> paragraphs = textElement.getComponents();
            for (TextComponent paragraph : paragraphs) {
                List<TextComponent> sentences = new ArrayList<>();
                List<TextComponent> punctuations = new ArrayList<>();
                for (TextComponent element : paragraph.getComponents()) {
                    switch (element.getParserType()) {
                        case PUNCTUATION:
                            punctuations.add(element);
                            break;
                        case SENTENCE:
                            sentences.add(element);
                            break;
                    }
                }
                ListIterator<TextComponent> sentenceIterator = sentences.listIterator();
                ListIterator<TextComponent> punctuationIterator = punctuations.listIterator();
                while (sentenceIterator.hasNext()) {
                    TextComponent nextS = sentenceIterator.next();
                    punctuationIterator.next();
                    if (nextS.getComponents().size() < sentenceSize) {
                        sentenceIterator.remove();
                        punctuationIterator.remove();
                    }
                }
                ListIterator<TextComponent> iterator = paragraph.getComponents().listIterator();
                while (iterator.hasNext()) {
                    iterator.next();
                    iterator.remove();
                }
                for (int i = 0; i < sentences.size(); i++) {
                    paragraph.addComponent(sentences.get(i));
                    paragraph.addComponent(punctuations.get(i));
                }
            }
        }
        LOGGER.info("Sentences were removed if their size less than - " + sentenceSize);
        return component;
    }

    public static Map<String, Integer> findSimilarWords(TextComponent component) throws TextActionException {
        if (component.getParserType() != ParserType.TEXT) {
            LOGGER.error("TextComponent type is not Text: " + component.getParserType().toString());
            throw new TextActionException("It's not TEXT parser type: " + component.getParserType().toString());
        }
        if (component.getComponents() == null) {
            LOGGER.error("TextComponent is null: " + component.getComponents());
            throw new TextActionException("Component is null: " + component.getComponents());
        }

        List<TextComponent> text = component.getComponents();
        List<TextComponent> allWords = new ArrayList<>();
        Map<String, Integer> result = new HashMap<>();

        for (TextComponent paragraph : text) {
            List<TextComponent> sentences = paragraph.getComponents();
            for (TextComponent sentence : sentences) {
                List<TextComponent> words = sentence.getComponents();
                for (TextComponent word : words) {
                    if (word.getParserType() != ParserType.PUNCTUATION) {
                        allWords.addAll(word.getComponents());
                    }
                }
            }
        }
        for (TextComponent word : allWords) {
            Integer count = 0;
            String type = word.toString();
            for (TextComponent s : allWords) {
                String wordString = s.toString();
                if (type.equalsIgnoreCase(wordString)) {
                    count++;
                }
                if (count > 1) {
                    result.put(type.toLowerCase(), count);
                }
            }

        }
        LOGGER.info("Similar words was find");
        return result;
    }
}
