package com.company.table;

import com.company.deck.Card;

import java.util.ArrayList;

public class GameTable {

     private ArrayList<Card> table = new ArrayList<Card>();

     public ArrayList displayTable() {
         return table;
     }

     public void addCard(Card card) {
         table.add(card);
     }
}
