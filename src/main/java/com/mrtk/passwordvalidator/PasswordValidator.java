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
        String[] positions = entryComponents[0].split("-");
        int firstPosition = Integer.parseInt(positions[0]);
        int secondPosition;
        if (positions.length > 1) {
            secondPosition = Integer.parseInt(positions[1]);
        } else {
            secondPosition = firstPosition;
        }
        char letter = entryComponents[1].charAt(0);
        String password = entryComponents[2];
        return new PasswordEntry(firstPosition, secondPosition, letter, password);
    }

    private static boolean isValid(PasswordEntry passwordEntry) {
        char letter = passwordEntry.getLetter();
        char first = passwordEntry.getPassword().charAt(passwordEntry.getFirstPosition() - 1);
        char second = passwordEntry.getPassword().charAt(passwordEntry.getSecondPosition() - 1);
        return ((first == letter) && (second != letter))
                || ((first != letter) && (second == letter));
    }
}
