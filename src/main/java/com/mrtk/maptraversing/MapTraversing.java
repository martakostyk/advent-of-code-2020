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

        List<Slope> slopes = List.of(
          new Slope(1,1),
          new Slope(3,1),
          new Slope(5,1),
          new Slope(7,1),
          new Slope(1,2)
        );

        try {
            char[][] map = parseMap(FileReader.read(path));
            System.out.println(slopes.stream()
                    .map(slope -> countTrees(map, slope))
                    .reduce(1L, (a, b) -> a * b));
        } catch (IOException ex) {
            // TODO
        }
    }

    private static long countTrees(char[][] map, Slope slope) {
        int row = 0;
        int column = 0;
        long encounteredTrees = 0L;
        while (row < map.length) {
            if (map[row][column] == '#') {
                encounteredTrees++;
            }
            if (column < map[0].length - slope.getRight()) {
                column = column + slope.getRight();
            } else {
                column = column + slope.getRight() - map[0].length;
            }
            row = row + slope.getDown();
        }
        return encounteredTrees;
    }

    private static char[][] parseMap(List<String> map) {
        return map.stream()
                .map(String::toCharArray)
                .toArray(char[][]::new);
    }
}