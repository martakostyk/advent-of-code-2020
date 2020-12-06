package com.mrtk.passwordvalidator;

import com.mrtk.filereader.FileReader;
import com.mrtk.reportrepair.ReportRepair;

import java.io.File;
import java.io.IOException;

public class PasswordValidator {

    public static void main(String[] args) {

        String path = new File(ReportRepair.class.getResource("/passwords.txt")
                .getFile()).getPath();
        try {
            System.out.println(FileReader.read(path)
                    .stream()
                    .map(PasswordValidator::parsePasswordEntry)
                    .filter(PasswordValidator::isValid)
                    .count());
        } catch (IOException ex) {
            // TODO
        }
    }

    private static PasswordEntry parsePasswordEntry(String passwordEntry) {
        String[] entryComponents = passwordEntry.split(" ");
        String[] occurrences = entryComponents[0].split("-");
        int minOccurences = Integer.parseInt(occurrences[0]);
        int maxOccurences;
        if (occurrences.length > 1) {
            maxOccurences = Integer.parseInt(occurrences[1]);
        } else {
            maxOccurences = minOccurences;
        }
        char letter = entryComponents[1].charAt(0);
        String password = entryComponents[2];
        return new PasswordEntry(minOccurences, maxOccurences, letter, password);
    }

    private static boolean isValid(PasswordEntry passwordEntry) {
        char[] chars = passwordEntry.getPassword().toCharArray();
        char letter = passwordEntry.getLetter();
        int occurrences = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == letter) {
                occurrences++;
            }
        }
        return occurrences >= passwordEntry.getMinOccurrences()
                && occurrences <= passwordEntry.getMaxOccurrences();
    }
}
