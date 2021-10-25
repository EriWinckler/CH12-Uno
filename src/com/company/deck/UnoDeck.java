package com.company.deck;


import com.company.actor.Hand;
import com.company.table.GameTable;

import java.util.*;

public class UnoDeck implements Deck {

    GameTable tableCards = new GameTable();
//    private List<Card> cards = new ArrayList<>();

    final private int[] VALUES = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
    final private String[] CARD_COLOR = { "Red", "Yellow", "Green", "Blue" };
    final private int[] WILD_CARDS = { 13, 14 };
    final private int[] ZERO_CARD = { 0 };

    public UnoDeck() {
        //add 4 wild cards
        for (int i = 0; i <= 3; i++) {
            for (int val : WILD_CARDS) {
                String wild = " ";
                tableCards.addCard(new PlayingCard(val, wild));
            }
        }

        for (String suit : CARD_COLOR) {
            //add zero cards
            for (int val : ZERO_CARD) {
                tableCards.addCard(new PlayingCard(val, suit));
            }

            //add number cards twice
            for (int i = 0; i <= 1; i++) {
                for (int val : VALUES) {
                    tableCards.addCard(new PlayingCard(val, suit));
                }
            }
        }
    }

    public void shuffle(ArrayList deck) {
        Collections.shuffle(deck);
    }

    public Card draw() {
        return tableCards.getRemainingDeckCards().remove(tableCards.getRemainingDeckCards().size() - 1);
    }

    public int size() { return tableCards.getRemainingDeckCards().size(); }

    public Card setColor(Card playedCard, String color) {
        playedCard.setSuit(color);
        return playedCard;
    }
}
