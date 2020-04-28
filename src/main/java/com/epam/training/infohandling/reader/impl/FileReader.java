package com.epam.training.infohandling.reader.impl;

import com.epam.training.infohandling.reader.FileManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader implements FileManager {
        private static final Logger logger = LogManager.getLogger(FileReader.class);
        @Override
        public List<String> readStrings() throws IOException {
            List<String> lines;
            Path path = Paths.get("src/main/resources/text.txt");

            try (Stream<String> lineStream = Files.newBufferedReader(path).lines()) {
                lines = lineStream.collect(Collectors.toList());
            } catch (IOException ex) {
                logger.error("Ошибка чтения", ex);
                throw new IOException("Ошибка чтения", ex);

            }
            logger.info("File read:" + lines);
            return lines;
        }

        List<String> readStrings(String path) throws IOException {
            List<String> lines;
            Path filePath = Paths.get(path);

            try (Stream<String> lineStream = Files.newBufferedReader(filePath).lines()) {
                lines = lineStream.collect(Collectors.toList());
            } catch (IOException ex) {
                logger.error("Ошибка чтения", ex);
                throw new IOException("Ошибка чтения", ex);

            }
            logger.info("File read:" + lines);
            return lines;
        }
}
