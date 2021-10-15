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

    public ArrayList<Card> getRemainingDeckCards() {
         return remainingDeckCards;
    }

    public void setRemainingDeckCards(ArrayList table) {
         remainingDeckCards = table;
    }
}
