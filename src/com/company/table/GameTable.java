package com.company.table;

import com.company.deck.Card;

import java.util.ArrayList;

public class GameTable {

     private ArrayList<Card> remainingDeckCards = new ArrayList<Card>();

     private ArrayList<Card> currentPile = new ArrayList<Card>();

     public ArrayList displayTable() {
         return currentPile;
     }

     public void addCard(Card card) {
         remainingDeckCards.add(card);
     }

     public void addCardCurrentPile(Card card) {
        currentPile.add(card);
    }

    public String getRemainingDeckCards() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < remainingDeckCards.size(); i++) {
            output.append(remainingDeckCards.get(i).display()).append(" | ");
        }
        return output.toString().trim();
    }

    public String getCurrentPileCard() {
        StringBuilder result = new StringBuilder();
        result.append(currentPile.get(currentPile.size() - 1).display());
        return result.toString();
    }

    public void setRemainingDeckCards(ArrayList table) {
         remainingDeckCards = table;
    }

    public int currentPileSize() { return currentPile.size(); }
}
