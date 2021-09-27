package com.company.uno;

import com.company.deck.Card;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards = new ArrayList<>();

    public void addCard (Card card) {
        cards.add(card);
    }

    public String displayHand() {
        StringBuilder output = new StringBuilder();
        for (Card card : cards) {
            output.append(card.display()).append(" ");
        }

        return output.toString().trim();
    }

    //method to drop cart to table
    public void dropCard() {
        
    }
}
