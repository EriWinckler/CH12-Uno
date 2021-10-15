package com.company.uno;

import com.company.actor.Actor;
import com.company.actor.Hand;
import com.company.actor.Player;
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

    //Initializing players array
    //private ArrayList<Player> players = new ArrayList<>();
    private List<Hand> hands = new ArrayList<>();

    private int playerCount = 0;
    private boolean isActive = true;

    //bolean for determining next color
    private boolean isRed = false;
    private boolean isGreen = false;
    private boolean isYellow = false;
    private boolean isBlue = false;

    //variables to implement draw + 2 and wild + 4
    private boolean addTwo = false;
    private boolean addFour = false;

    //Round counter variable
    private int round = 0;

    //Creating variable to keep track of the current player
    private Hand currentPlayer;

    GameTable table = new GameTable();

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
        //Round counter
        round += 1;

        for (int i = 0; i < hands.size(); i++) {
            Hand activeHand = hands.get(i);
            if(round == 1) {
                for(int j = 0; j <= 6; j++) {
                    activeHand.addCard(deck.draw());
                }
            }
            turn(activeHand);
        }

        //add remaining cards to correct pile
        table.setRemainingDeckCards((ArrayList) deck.drawAll());

    }

    private boolean turn(Hand activeHand) {
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
        table.addCardCurrentPile(activeHand.removeCard(choice));

//        if(rankChoice == 10) {
//            //skip player
//        }
//
//        if(rankChoice == 11) {
//            addTwo = true;
//        }
//
//        if(rankChoice == 12) {
//            //reverse
//        }
//
//        if(rankChoice == 13) {
//            String rankColor = "";
//            int choice = wildChoice();
//            switch (choice) {
//                case 1 -> rankColor = "Red";
//                case 2 -> rankColor = "Yellow";
//                case 3 -> rankColor = "Green";
//                case 4 -> rankColor = "Blue";
//            }
//        }

//        int position = -1;
//        position = activeHand.getCards().indexOf(choice);
//        if (position == -1) {
//            System.out.println("Invalid Input");
//            cardDrop(activeHand);
//        } else {
//            table.addCard((Card) activeHand.getCards().get(position));
//            activeHand.removeCard(position);
//        }
        return true;
    };

    private int wildChoice() {
        int choice =  Console.getInt(
                1,
                4,
                "Please select which color would you like:\n" +
                        "1 - Red\n" +
                        "2 - Yellow\n" +
                        "3 - Green\n" +
                        "4 - Blue",
                "Invalid Choice"
        );
        return choice;
    }

    private boolean buyCard(Hand activeHand) {
        activeHand.addCard(deck.draw());
        return true;
    }

    private void removePlayer(String name) {
        for(Hand hand : hands) {
            if(hand.getName().equals(name)) {
                hands.remove(name);
            }
        }
    }
}
