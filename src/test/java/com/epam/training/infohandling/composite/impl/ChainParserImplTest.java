package com.epam.training.infohandling.composite.impl;

import com.epam.training.infohandling.entity.ParserType;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ChainParserImplTest {
    private ChainParserImpl chainParser = new ChainParserImpl(ParserType.TEXT, null);

    private static final String TEXT = "It has survived - not only (five) centuries, but also " +
            "but also the leap into electronic typesetting, remaining essentially unchanged.  " +
            "This is example text to check parser. Second sentence!  " +
            "New paragraph. Sentence number 2 1 / in this paragraph.  " +
            "Bye.";

    @Test
    public void testParse_typeText_resultType_true() {
        //given
        ParserType actualType = ParserType.TEXT;
        //when
        ParserType resultType = chainParser.parse(TEXT).getParserType();
        //then
        Assert.assertEquals(actualType,resultType);
    }

    @Test
    public void testParse_typeLetter_resultType_false() {
        //given
        ParserType actualType = ParserType.LETTER;
        //when
        ParserType resultType = chainParser.parse(TEXT).getParserType();
        boolean expression = actualType.equals(resultType);
        //then
        Assert.assertFalse(expression);
    }
    @Test
    public void testParse_typeLetter_nextComponentType_true(){
        //given
        ParserType actualType = ParserType.LETTER;
        //when
        ParserType resultType = chainParser.parse(TEXT).getComponents().get(0).getParserType();

        //then
        Assert.assertEquals(actualType, resultType);
    }
    @Test
    public void testParse_typeParagraph_nextComponentType_false(){
        //given
        ParserType actualType = ParserType.PARAGRAPH;
        //when
        ParserType resultType = chainParser.parse(TEXT).getComponents().get(0).getParserType();
        boolean expression = actualType.equals(resultType);
        //then
        Assert.assertFalse(expression);
    }
}