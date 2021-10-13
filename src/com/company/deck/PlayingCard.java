package com.company.deck;

public class PlayingCard extends Card {
    public PlayingCard(int rank, String suit) {
        super( rank, suit );
    }

    @Override
    public String display() {
        String output = "";
        switch(rank) {
            case 10 -> {
                output = "Skip";
                return output + " " + suit;
            }
            case 11 -> {
                output = "Draw Two";
                return output + " " + suit;
            }
            case 12 -> {
                output = "Reverse";
                return output + " " + suit;
            }
            case 13 -> {
                output = "Wild Draw";
                return output;
            }
            case 14 -> {
                output = "Wild Draw + 4";
                return output;
            }
            default -> {
                output = rank == 10 ? Integer.toString(rank) :
                        " " + rank;
                return output + " " + suit;
            }
        }
    }
}
