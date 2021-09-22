package com.company;

import com.company.deck.Deck;
import com.company.deck.UnoDeck;

public class Main {

    public static void main(String[] args) {

        Deck deck = new UnoDeck();
        deck.shuffle();
        System.out.println(deck.draw().display());
        System.out.println(deck.draw().display());
        System.out.println(deck.draw().display());
        System.out.println(deck.draw().display());
        System.out.println(deck.draw().display());
        System.out.println(deck.draw().display());
    }
}
