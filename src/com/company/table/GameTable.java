package com.company.table;

import com.company.deck.Card;

import java.util.ArrayList;

public class GameTable {

    private ArrayList<Card> remainingDeckCards = new ArrayList<Card>();

     private ArrayList<Card> discardPile = new ArrayList<Card>();

     public ArrayList displayTable() {
         return discardPile;
     }

     public void addCard(Card card) {
         remainingDeckCards.add(card);
     }

     public void addCardDiscardPile(Card card) {
        discardPile.add(card);
    }

    public Card getDiscardPileCard() {
         Card card = discardPile.get(discardPile.size() - 1);
         return card;
    }

    public void setRemainingDeckCards(ArrayList<Card> remainingDeckCards) {
        this.remainingDeckCards = remainingDeckCards;
    }

//    public void setRemainingDeckCards(ArrayList table) {
//         remainingDeckCards = table;
//    }

    public String getCurrentDiscardPileCard() {
        StringBuilder result = new StringBuilder();
        result.append(discardPile.get(discardPile.size() - 1).display());
        return result.toString();
    }

    public int currentPileSize() { return discardPile.size(); }
}
