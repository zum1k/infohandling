package com.epam.training.infohandling.action;

import com.epam.training.infohandling.composite.TextComponent;
import com.epam.training.infohandling.composite.impl.ChainCreator;
import com.epam.training.infohandling.composite.impl.TextComposite;
import com.epam.training.infohandling.entity.ParserType;
import com.epam.training.infohandling.exception.TextActionException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;


public class TextActionTest {
    private static final String TEXT = "It has survived - not only (five) centuries, but also " +
            "but also the leap into electronic typesetting, remaining essentially unchanged.  " +
            "This is example text to check parser. Second sentence!  " +
            "New paragraph. Sentence number 2 1 / in this paragraph.  " +
            "Bye.";

    private static final String SORTED_TEXT = "It has survived - not only (five) centuries, but also but also the leap into electronic typesetting, remaining essentially unchanged.  " +
            "Bye.  " +
            "This is example text to check parser. Second sentence!  " +
            "New paragraph. Sentence number 2 1 / in this paragraph.";

    private static final String REMOVED_TEXT = "It has survived - not only (five) centuries, but also " +
            "but also the leap into electronic typesetting, remaining essentially unchanged.  " +
            "This is example text to check parser.  " +
            "Sentence number 2 1 / in this paragraph.";


    private ChainCreator creator = new ChainCreator();

    @Test
    public void testSortParagraphs_sortedActualText_sortedText_true() throws TextActionException {
        //given
        TextComponent component = creator.createChain(TEXT);
        //when
        String resultString = TextAction.sortParagraphs(component).toString();
        //then
        Assert.assertEquals(SORTED_TEXT, resultString);
    }

    @Test
    public void testRemoveSentencesBySize_three_true() throws TextActionException {
        TextComponent component = creator.createChain(TEXT);
        //given
        int sentenceSizeLessThan = 3;
        //when
        String resultString = TextAction.removeSentencesBySize(component, sentenceSizeLessThan).toString();
        //then
        Assert.assertEquals(REMOVED_TEXT, resultString);
    }

    @Test
    public void testFindSimilarWords_wordParagraphTwoTimes_true() throws TextActionException {
        //given
        TextComponent component = creator.createChain(TEXT);
        int maxCountWordParagraph = 2;
        //when
        Map<String, Integer> similarWords = TextAction.findSimilarWords(component);
        int result = similarWords.get("paragraph");
        //then
        Assert.assertEquals(maxCountWordParagraph, result);
    }

    @Test(expectedExceptions = TextActionException.class)
    public void testFindSimilarWords_typeSentence_TextActionException() throws TextActionException {
        //given
        TextComponent component = new TextComposite(ParserType.SENTENCE);
        //when
        Map<String, Integer> result = TextAction.findSimilarWords(component);
    }

    @Test(expectedExceptions = TextActionException.class)
    public void testRemoveSentencesBySize_typeSentence_TextActionException() throws TextActionException {
        //given
        int sentenceSize = 3;
        TextComponent component = new TextComposite(ParserType.SENTENCE);
        //when
        TextComponent result = TextAction.removeSentencesBySize(component, sentenceSize);
    }
    @Test(expectedExceptions = TextActionException.class)
    public void testSortParagraphs_typeLetter_TextActionException() throws TextActionException {
        //given
        TextComponent component = new TextComposite(ParserType.LETTER);
        //when
        String resultString = TextAction.sortParagraphs(component).toString();
    }
}