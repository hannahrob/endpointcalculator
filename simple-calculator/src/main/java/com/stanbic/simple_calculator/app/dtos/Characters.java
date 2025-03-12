package com.stanbic.simple_calculator.app.dtos;

import java.util.ArrayList;

public class Characters {
    private String letter;
    private String splitCharacter;

    public Characters(String letter, String splitCharacter) {
        this.letter = letter;
        this.splitCharacter = splitCharacter;
    }

    public String getLetter() {
        return letter;
    }

    public String getSplitCharacter() {
        return splitCharacter;
    }

}
