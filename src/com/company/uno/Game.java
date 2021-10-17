package com.company.uno;

import com.company.actor.Actor;
import com.company.actor.Hand;
import com.company.actor.Player;
import com.company.deck.Card;
import com.company.deck.Deck;
import com.company.deck.UnoDeck;
import com.company.table.GameTable;
import com.company.utils.Console;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private int numberPlayers;

    //initializing deck
    private Deck deck = new UnoDeck();

    //Initializing hand array
    private List<Hand> hands = new ArrayList<>();

    //Initializing table
    GameTable table = new GameTable();

    private int playerCount = 0;

    //Active game checker
    private boolean isActive = true;

    //Uno checker
    private boolean uno = false;

    //Skip card setter
    private boolean shouldSkip = false;

    //booleans to implement draw + 2 and wild + 4
    private boolean addTwo = false;
    private boolean addFour = false;

    //Round counter variable
    private int round = 0;

    //Creating variable to keep track of the current player
    private Hand currentPlayer;



    public void startGame() {
        System.out.println("Welcome to Eri's Uno Game");
        deck.shuffle();
        numberPlayers = Console.getInt(2,
                10,
                "How many players are playing?",
                "Invalid number of players, try again");

        while(numberPlayers > hands.size()) {
            createPlayer();
        }

        while(isActive) {
            round();
        }
    }

    private void createPlayer() {
        String name = Console.getString("Please enter player " + (playerCount + 1) + " name", true);
        Player player = new Player(name);
        hands.add(new Hand(player));
        playerCount++;
    }

    private void round() {
        //add remaining cards to correct pile
        table.setRemainingDeckCards((ArrayList) deck.drawAll());

        for (int i = 0; i < hands.size(); i++) {
            //Round counter
            round += 1;

            Hand activeHand = hands.get(i);
            if(activeHand.size() == 0 && !uno) {
                for(int j = 0; j <= 6; j++) {
                    activeHand.addCard(deck.draw());
                }
            }
            turn(activeHand);
        }
    }

    private boolean turn(Hand activeHand) {
        //Skip card checker
        skip();

        //determine if should display top card on pile
        displayTopCard();

        //Draw Two checker
        drawTwoChecker(activeHand);

        int choice = activeHand.getAction();
        return switch (choice) {
            case Actor.DROP_A_CARD -> cardDrop(activeHand);
            case Actor.BUY_A_CARD -> buyCard(activeHand);
            default -> false;
        };
    }

    private boolean cardDrop(Hand activeHand) {
        activeHand.displayHand(activeHand);

        int choice = Console.getInt(
                0,
                activeHand.size(),
                "Select the position of the card you want to play",
                "Invalid Input"
        );

        actionCardChecker(activeHand.getPlayedCard(activeHand, choice));
        //TODO
//        wildCardChecker();
        table.addCardCurrentPile(activeHand.removeCard(choice));

        return true;
    };

    private void actionCardChecker(Card playedCard) {
        //Skip
        if(playedCard.getRank() == 10) {
            shouldSkip = true;
        }

        //Draw Two
        if(playedCard.getRank() == 11) {
            addTwo = true;
        }

        //Reverse
        if(playedCard.getRank() == 12) {}
    }

    private boolean buyCard(Hand activeHand) {
        activeHand.addCard(deck.draw());
        return true;
    }

    private void drawTwoChecker(Hand activeHand) {
        if(addTwo) {
            buyCard(activeHand);
            buyCard(activeHand);
            addTwo = false;
        }
    }

    private void skip() {
        if(shouldSkip) {
            shouldSkip = false;
            round();
        }
    }

    public void displayTopCard() {
        if(table.currentPileSize() > 0) {
            System.out.println("Card on top of pile = " + table.getCurrentPileCard());
        }
    }

    private void removePlayer(String name) {
        for(Hand hand : hands) {
            if(hand.getName().equals(name)) {
                hands.remove(name);
            }
        }
    }
}
