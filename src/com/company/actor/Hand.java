package com.company.actor;

import com.company.actor.Actor;
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

    public String displayHand(Hand activeHand) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < cards.size(); i++) {
            output.append(cards.get(i).display()).append(" " + "(" + i + ")" +
                    " |" +
                    " ");
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
