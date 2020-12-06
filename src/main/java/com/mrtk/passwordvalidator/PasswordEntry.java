package com.mrtk.passwordvalidator;

public class PasswordEntry {

    private final int firstPosition;
    private final int secondPosition;
    private final char letter;
    private final String password;

    public PasswordEntry(int firstPosition, int secondPosition, char letter, String password) {
        this.firstPosition = firstPosition;
        this.secondPosition = secondPosition;
        this.letter = letter;
        this.password = password;
    }

    public int getFirstPosition() {
        return firstPosition;
    }

    public int getSecondPosition() {
        return secondPosition;
    }

    public char getLetter() {
        return letter;
    }

    public String getPassword() {
        return password;
    }
}
