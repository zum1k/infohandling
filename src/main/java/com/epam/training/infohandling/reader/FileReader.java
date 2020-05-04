package com.epam.training.infohandling.reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {
    private static final Logger LOGGER = LogManager.getLogger(FileReader.class);

    List<String> readStrings(String path) throws IOException {
        List<String> lines;
        Path filePath = Paths.get(path);

        try (Stream<String> lineStream = Files.newBufferedReader(filePath).lines()) {
            lines = lineStream.collect(Collectors.toList());
        } catch (IOException ex) {
            LOGGER.error("Ошибка чтения", ex);
            throw new IOException("Ошибка чтения", ex);

        }
        LOGGER.info("File read:" + lines);
        return lines;
    }
}
