package com.company;

import com.company.deck.Deck;
import com.company.deck.UnoDeck;
import com.company.uno.Game;

public class Main {

    public static void main(String[] args) {

        Deck deck = new UnoDeck();
        deck.shuffle();

        Game game = new Game();
        game.startGame();

    }
}
