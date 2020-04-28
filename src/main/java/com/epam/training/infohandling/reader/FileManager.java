package com.epam.training.infohandling.reader;

import java.io.IOException;
import java.util.List;

public interface FileManager {
    List<String> readStrings() throws IOException;
}
