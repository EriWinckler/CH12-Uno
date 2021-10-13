package com.company.actor;

public interface Actor {
    int DROP_A_CARD = 1;
    int BUY_A_CARD = 2;

    String getName();
    int getAction(Hand hand);
}
