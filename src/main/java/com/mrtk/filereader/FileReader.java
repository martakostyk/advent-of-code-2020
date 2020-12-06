package com.mrtk.filereader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class FileReader {

    public static List<String> read(String path) throws IOException {
        return Files.lines(Path.of(path)).collect(Collectors.toList());
    }
}
