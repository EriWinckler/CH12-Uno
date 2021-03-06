package com.company.deck;

public class PlayingCard extends Card {
    public PlayingCard(int rank, String suit) {
        super( rank, suit );
    }

    @Override
    public String display() {
        String output = "";
        switch(rank) {
            case 10 -> output = "Skip";

            case 11 -> output = "Draw Two";

            case 12 -> output = "Reverse";

            case 13 -> output = "Wild";

            case 14 -> output = "Wild Draw + 4";

            default -> output = rank == 10 ? Integer.toString(rank) :
                " " + rank;
        }

        return output + " " + suit;
    }
}
