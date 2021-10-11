package com.company.uno;

import com.company.deck.Card;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards = new ArrayList<>();
    private Actor holder;

    public Hand(Actor holder) {
        this.holder = holder;
    }

    //add card to card list
    public void addCard(Card card) {
        cards.add(card);
    }

    public String displayHand() {
        StringBuilder output = new StringBuilder();
        for (Card card : cards) {
            output.append(card.display()).append(" | ");
        }

        return output.toString().trim();
    }

    public int size() { return cards.size(); }

    public String getName() { return holder.getName(); }

    public int getAction() {
        return holder.getAction(this);
    }

    public List getCards() { return cards; }

    // removeCard method
    public Card removeCard(int value) {
        // take card at index out of hand and return to table.
        return cards.remove(value);
    }
}
