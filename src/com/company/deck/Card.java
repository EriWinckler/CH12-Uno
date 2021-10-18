package com.company.deck;

public abstract class Card {
    protected int rank;
    protected String suit;

    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank() { return rank; }

    public String getSuit() { return suit; }

    public void setSuit(String color) {
        suit = color;
    }

    public abstract String display();


}
