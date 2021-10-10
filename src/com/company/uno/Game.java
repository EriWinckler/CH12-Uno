package com.company.uno;

import com.company.actor.Player;
import com.company.table.GameTable;
import com.company.utils.Console;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private int numberPlayers;



    //Initializing players array
    //private ArrayList<Player> players = new ArrayList<>();
    private List<Hand> hands = new ArrayList<>();

    private int playerCount = 0;
    private boolean isActive = true;

    //Round counter variable
    private int round = 0;

    //Creating variable to keep track of the current player
    private Hand currentPlayer;

    GameTable table = new GameTable();

    public void startGame() {
        System.out.println("Welcome to Eri's Uno Game");
        numberPlayers = Console.getInt(2, 10, "How many players are playing?", "Invalid number of players, try again");

        while(numberPlayers > hands.size()) {
            createPlayer();
        }

        while(isActive) {
            round();
        }
    }

    public void createPlayer() {
        String name = Console.getString("Please enter player " + playerCount + " name", true);
        Player player = new Player(name);
        hands.add(new Hand(player));
        playerCount++;
    }

    public void round() {
        //Round counter
        round += 1;

        for (int i = 0; i < hands.size(); i++) {
            Hand player = hands.get(i);
            player.getAction();
        }
    }

    public void removePlayer(String name) {
        for(Hand hand : hands) {
            if(hand.getName().equals(name)) {
                hands.remove(name);
            }
        }
    }
}
