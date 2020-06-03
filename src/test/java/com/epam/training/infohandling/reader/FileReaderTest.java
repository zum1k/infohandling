package com.epam.training.infohandling.reader;

import com.epam.training.infohandling.exception.InvalidPathException;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FileReaderTest {

    private static final String VALID_PATH = "src/test/resources/data/text.txt";
    private static final String INVALID_PATH = "qwertysrc/test/resources/data/text.txt";

    private final TextReader textReader = new TextReader();

    String TEXT = "It has survived - not only (five) centuries, but also " +
            "but also the leap into electronic typesetting, remaining essentially unchanged.\n" +
            "This is example text to check parser. Second sentence!\n" +
            "New paragraph. Sentence number 2 1 / in this paragraph.\n" +
            "Bye.\n";

    @Test
    public void testReadStrings_FieldText_ParsedText_True() throws InvalidPathException {
        //when
        String resultText = textReader.readStrings(VALID_PATH);
        //then
        Assert.assertEquals(TEXT, resultText);
    }

    @Test(expectedExceptions = InvalidPathException.class)
    public void testReadStrings_InvalidPathException() throws InvalidPathException {
        //when
        String resultText = textReader.readStrings(INVALID_PATH);
    }
}