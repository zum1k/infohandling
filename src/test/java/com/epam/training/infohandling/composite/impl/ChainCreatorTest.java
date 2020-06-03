package com.epam.training.infohandling.composite.impl;

import com.epam.training.infohandling.composite.TextComponent;
import com.epam.training.infohandling.entity.ParserType;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ChainCreatorTest {

    private ChainCreator chainCreator = new ChainCreator();

    private static final String TEXT = "It has survived - not only (five) centuries, but also " +
            "but also the leap into electronic typesetting, remaining essentially unchanged.  " +
            "This is example text to check parser. Second sentence!  " +
            "New paragraph. Sentence number 2 1 / in this paragraph.  " +
            "Bye.";

    @Test
    public void testCreateChain_text_parsedType_true() {
        //given
        ParserType type = ParserType.TEXT;
        //when
        TextComponent component = chainCreator.createChain(TEXT);
        //then
        Assert.assertEquals(type, component.getParserType());
    }
    @Test
    public void testCreateChain_stringText_parsedText_true(){
        //when
        TextComponent resultComponent = chainCreator.createChain(TEXT);
        //then
        Assert.assertEquals(TEXT, resultComponent.toString());
    }
}