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

public class Game {
    private int numberPlayers;

    //initializing deck
    private Deck deck = new UnoDeck();

    //Initializing hand array
    private ArrayList<Hand> hands = new ArrayList<>();

    //Initializing table
    public GameTable table = new GameTable();

    private int playerCount = 0;

    //Active game checker
    private boolean isActive = true;

    //Skip card setter
    private boolean shouldSkip = false;

    //Reverse card setter
    private boolean isReverse = false;

    //booleans to implement draw + 2 and wild + 4
    private boolean addTwo = false;
    private boolean addFour = false;

    public void startGame() {
        System.out.println("Welcome to Eri's Uno Game");
        deck.shuffle();
        numberPlayers = Console.getInt(
                2,
                10,
                "How many players are playing?",
                "Invalid number of players, try again"
        );

        while(numberPlayers > hands.size()) {
            createPlayer();
        }

        firstDraw();

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

    private void firstDraw() {
        table.addCardDiscardPile(deck.draw());
        if(table.getDiscardPileCard().getRank() >= 10) {
            table.addCard(table.getDiscardPileCard());
            deck.shuffle();
            firstDraw();
        }

        //hand first draw
        for (int i = 0; i < hands.size(); i++) {
            Hand activeHand = hands.get(i);
            for (int j = 0; j <= 7; j++) {
                activeHand.addCard(deck.draw());
            }
        }
    }

    private void round() {
        for (int i = 0; i < hands.size();) {
            //skip card checker
            i = skip(i);

            Hand activeHand = hands.get(i);

            //add cards to hands on first round
            turn(activeHand);

            //reverse card operator
            if(isReverse) {
                if(i <= 0) {
                    i = hands.size();
                }
                i--;
            } else {
                i++;
            }
        }
    }

    private boolean turn(Hand activeHand) {
        //display top card on active pile
        displayTopCard();

        //special cards checker
        specialCardActivator(activeHand);

        int choice = activeHand.getAction();

        return switch (choice) {
            case Actor.DROP_A_CARD -> cardDrop(activeHand);
            case Actor.BUY_A_CARD -> buyCard(activeHand);
            default -> false;
        };
    }

    private void specialCardActivator(Hand activeHand) {
        //Draw Two checker
        drawTwoChecker(activeHand);

        //Draw four checker
        drawFourChecker(activeHand);
    }

    private boolean cardDrop(Hand activeHand) {
        activeHand.displayHand(activeHand);

        int choice = Console.getInt(
                -1,
                activeHand.size() - 1,
                "Select the position of the card you want to play, select (-1) if you don't have a playable card.",
                "Invalid Input"
        );

        //checker for miss type choice
        if(choice == -1) {
            turn(activeHand);
            return false;
        }

        cardDropChecker(activeHand.getPlayedCard(activeHand, (choice)),
                activeHand);

        //Special cards
        specialCardChecker(activeHand.getPlayedCard(activeHand, (choice)));
        activeHand.removeCard(choice);

        //Victory checkers
        unoChecker(activeHand);
        winnerChecker(activeHand);
        return true;
    };

    private void cardDropChecker(Card card, Hand activeHand) {
        Card currentCard = table.getDiscardPileCard();
        if(card.getRank() >= 13) {
                table.addCardDiscardPile(card);
                return;
        }

        if(card.getSuit() == currentCard.getSuit() || card.getRank() == currentCard.getRank()) {
            table.addCardDiscardPile(card);
            return;
        }

        System.out.println("Invalid card selected");
        cardDrop(activeHand);
    }

    private Card specialCardChecker(Card playedCard) {
        //Skip
        if(playedCard.getRank() == 10) {
            shouldSkip = true;
        }

        //Draw Two
        if(playedCard.getRank() == 11) {
            addTwo = true;
            shouldSkip = true;
        }

        //Reverse
        if(playedCard.getRank() == 12) {
            //TODO fix for 2 players
            if (hands.size() == 2) {
                shouldSkip = true;
            } else {
                isReverse = !isReverse;
            }
        }

        //Wild
        if(playedCard.getRank() == 13) {
            shouldSkip = true;
            playedCard = wildChooser(playedCard);
        }

        //WildDraw +4
        if(playedCard.getRank() == 14) {
            addFour = true;
            shouldSkip = true;
            playedCard = wildChooser(playedCard);
        }

        return playedCard;
    }

    private Card wildChooser(Card playedCard) {
        int choice = Console.getInt(
                1,
                4,
                "Select the color you would like:\n" +
                        "1 - Red\n" +
                        "2 - Yellow\n" +
                        "3 - Green\n" +
                        "4 - Blue",
                "Invalid Input"
        );

        String color = "";

        switch(choice) {
            case 1 -> color = "Red";
            case 2 -> color = "Yellow";
            case 3 -> color = "Green";
            case 4 -> color = "Blue";
            default -> System.out.println("Invalid input");
        }
        Card wildCard;

        return wildCard = deck.setColor(playedCard, color);
    }

    private void unoChecker(Hand activeHand) {
        if(activeHand.size() == 1) {
            System.out.println("\n\n\n" + activeHand.getName() + " UNO! \n\n\n");
            activeHand.setUno(true);
        }
        if(activeHand.size() > 1) {
            activeHand.setUno(false);
        }
    }

    private void winnerChecker(Hand activeHand) {
        if(activeHand.size() == 0) {
            System.out.println("\n\n\n" + activeHand.getName() + " WON!\n\n\n");
            isActive = false;
        }
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
            shouldSkip = true;
        }
    }

    private void drawFourChecker(Hand activeHand) {
        if(addFour) {
            for(int i = 0; i <= 3; i++) {
                buyCard(activeHand);
            }
            addFour = false;
            shouldSkip = true;
        }
    }

    private int skip(int i) {
        if(shouldSkip && isReverse) {
            shouldSkip = false;
            if(i >= hands.size()) {
                i = hands.size();
                return i;
            }
            i--;
            return i--;
        }

        if(shouldSkip) {
            shouldSkip = false;
            if(i >= hands.size() - 1) {
                i = 0;
                return i++;
            }
            i++;
            return i++;
        }
        return i;
    }

    public void displayTopCard() {
        if(table.currentPileSize() > 0) {
            System.out.println("Card on top of pile = " + table.getCurrentDiscardPileCard());
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
