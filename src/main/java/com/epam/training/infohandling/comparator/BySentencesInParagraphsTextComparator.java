package com.epam.training.infohandling.comparator;

import com.epam.training.infohandling.composite.TextComponent;

import java.util.Comparator;
import java.util.List;

public class BySentencesInParagraphsTextComparator implements Comparator<TextComponent> {
    @Override
    public int compare(TextComponent firstParagraph, TextComponent secondParagraph) {
        List<TextComponent> firstSentences = firstParagraph.getComponents();
        List<TextComponent> secondSentences = secondParagraph.getComponents();
        int firstSentencesAmount = firstSentences.size();
        int secondSentencesAmount = secondSentences.size();
        return Integer.compare(firstSentencesAmount, secondSentencesAmount);
    }
}
