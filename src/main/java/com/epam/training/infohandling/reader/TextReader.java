package com.epam.training.infohandling.reader;

import com.epam.training.infohandling.exception.InvalidPathException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextReader {
    private static final Logger LOGGER = LogManager.getLogger(TextReader.class);

    public String readStrings(String filePath) throws InvalidPathException {
        try {
            StringBuilder text = new StringBuilder();
            Scanner scanner = new Scanner(new java.io.FileReader(filePath));
            LOGGER.info("Path is valid.");
            while (scanner.hasNextLine()) {
                String paragraph = scanner.nextLine();
                text.append(paragraph);
                text.append("\n");
            }
            LOGGER.info("Strings has been read.");
            return text.toString();
        } catch (FileNotFoundException e) {
            LOGGER.info("Path is invalid. " + e);
            throw new InvalidPathException(filePath, e);
        }
    }
}
