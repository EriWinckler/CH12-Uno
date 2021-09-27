package com.company.table;

import java.util.ArrayList;

public class GameTable {
     private ArrayList<String> players = new ArrayList<String>();

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
