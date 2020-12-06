package com.mrtk.maptraversing;

import com.mrtk.filereader.FileReader;
import com.mrtk.reportrepair.ReportRepair;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MapTraversing {

    public static void main(String[] args) {

        String path = new File(ReportRepair.class.getResource("/map.txt")
                .getFile()).getPath();

        try {
            char[][] map = parseMap(FileReader.read(path));
            System.out.println(countTrees(map));
        } catch (IOException ex) {
            // TODO
        }
    }

    private static int countTrees(char[][] map) {
        int row = 0;
        int column = 0;
        int encounteredTrees = 0;
        while (row < map.length) {
            if (map[row][column] == '#') {
                encounteredTrees++;
            }
            if (column < map[0].length - 3) {
                column = column + 3;
            } else {
                column = column + 3 - map[0].length;
            }
            row++;
        }
        return encounteredTrees;
    }

    private static char[][] parseMap(List<String> map) {
        return map.stream()
                .map(String::toCharArray)
                .toArray(char[][]::new);
    }
}