package com.company.deck;

import com.company.utils.Console;

public class RiggedUnoDeck implements Deck {
    final private String[] SUITS = {"Red", "Yellow", "Green", "Blue"};

    @Override
    public void shuffle() {
        return;
    }

    @Override
    public Card draw() {
        int value = Console.getInt(0,
                14,
                "Enter number 1-13\n10 = Skip  11 = Draw Two\n12 = Reverse  13 = Wild Draw \n14 = Wild Draw + 4",
                "invalid entry");
        int suit = Console.getInt(1, 4, "1. Red | 2. Yellow | 3. Green | 4. Blue", "Invalid entry");
        return new PlayingCard(value, SUITS[suit - 1]);
    }
}
