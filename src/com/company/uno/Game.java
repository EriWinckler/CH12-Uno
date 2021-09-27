package com.company.uno;

import com.company.actor.Player;
import com.company.table.GameTable;
import com.company.utils.Console;

import java.util.ArrayList;

public class Game {
    private int numberPlayers;

    //Initializing players array
    public ArrayList<Player> players = new ArrayList<>();

    GameTable table = new GameTable();

    public void startGame() {
        System.out.println("Welcome to Eri's Uno Game");
        numberPlayers = Console.getInt(2, 10, "How many players are playing?", "Invalid number of players, try again");

        while(numberPlayers > players.size()) {
            
        }
    }
}
