package com.company.deck;

public class PlayingCard extends Card {
    public PlayingCard(int rank, String suit) {
        super( rank, suit );
    }

    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    @Override
    public String display() {
        String output = "";
        switch(rank) {
            case 10 -> output = "Skip";

            case 11 -> output = "Draw Two";

            case 12 -> output = "Reverse";

            case 13 -> output = "Wild Draw";

            case 14 -> output = "Wild Draw + 4";

            default -> output = rank == 10 ? Integer.toString(rank) :
                " " + rank;
        }

        return output + " " + suit;
    }
}
