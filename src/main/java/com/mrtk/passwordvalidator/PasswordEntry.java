package com.mrtk.passwordvalidator;

public class PasswordEntry {

    private final int minOccurrences;
    private final int maxOccurrences;
    private final char letter;
    private final String password;

    public PasswordEntry(int minOccurrences, int maxOccurrences, char letter, String password) {
        this.minOccurrences = minOccurrences;
        this.maxOccurrences = maxOccurrences;
        this.letter = letter;
        this.password = password;
    }

    public int getMinOccurrences() {
        return minOccurrences;
    }

    public int getMaxOccurrences() {
        return maxOccurrences;
    }

    public char getLetter() {
        return letter;
    }

    public String getPassword() {
        return password;
    }
}
