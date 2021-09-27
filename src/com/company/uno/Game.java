package com.company.uno;

import com.company.actor.Player;
import com.company.table.GameTable;
import com.company.utils.Console;

import java.util.ArrayList;

public class Game {
    private int numberPlayers;

    //Initializing players array
    private ArrayList<Player> players = new ArrayList<>();

    private int playerCount = 0;
    private boolean isActive = true;

    //Round counter variable
    private int round = 0;

    //Creating variable to keep track of the current player
    private Player currentPlayer;

    GameTable table = new GameTable();

    public void startGame() {
        System.out.println("Welcome to Eri's Uno Game");
        numberPlayers = Console.getInt(2, 10, "How many players are playing?", "Invalid number of players, try again");

        while(numberPlayers > players.size()) {
            players.add(createPlayer());
        }

        while(isActive) {
            round();
        }
    }

    public Player createPlayer() {
        String name = Console.getString("Please enter player name", true);
        Player player = new Player(name);
        playerCount++;
        return player;
    }

    public void round() {
        //Round counter
        round += 1;

        //TODO Create game checker
        for (int i = 0; i < players.size(); i++) {
            currentPlayer = players.get(i);

        }
    }
}
