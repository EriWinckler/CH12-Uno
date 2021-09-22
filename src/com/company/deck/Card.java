package com.company.deck;

public class Card {
    private int value;
    private String suit;

    public Card(int value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    public int getValue() {return value;}

    public String display() {
        String output = "";
        switch(value) {
            case 10 -> output = "Skip";
            case 11 -> output = "Draw Two";
            case 12 -> output = "Reverse";
            case 13 -> output = "Wild Draw";
            case 14 -> output = "Wild Draw + 4";
            default -> output = value == 10 ? Integer.toString(value) : " " + value;
        }
        return output + " " + suit;
    }
}
