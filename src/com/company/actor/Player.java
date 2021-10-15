package com.company.actor;

import com.company.utils.Console;

public class Player implements Actor {
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAction(Hand hand) {
        System.out.println(name + " Cards:" + "\n" + hand.displayHand(hand));
        System.out.println("What would you like to do? \n1 - Drop a card\n2 - Buy a card");
        return Console.getInt(1, 3, "Choose action", "Invalid action");
    }


}
