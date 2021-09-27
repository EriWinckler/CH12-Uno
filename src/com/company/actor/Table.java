package com.company.actor;

import java.util.ArrayList;

public class Table {
     private ArrayList<String> players = new ArrayList<String>();
    /*
    table
    hands
    displaytable
    remove player
     */

     private ArrayList<String> table = new ArrayList<String>();

     public ArrayList displayTable() {
         return table;
     }

     public void removePlayer(String name) {
          for(String player : players) {
               if(player.equals(name)) {
                    players.remove(name);
               }
          }
     }
}
