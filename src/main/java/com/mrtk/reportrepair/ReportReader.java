package com.mrtk.reportrepair;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class ReportReader {

    public static int[] readReport(String path) throws IOException {
        return Files.readAllLines(Path.of(path))
                .stream()
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
