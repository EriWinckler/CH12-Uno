package com.company.uno;

import com.company.utils.Console;

public interface Actor {
    int DROP_A_CARD = 1;
    int BUY_A_CARD = 2;

    String getName();
    int getAction(Hand hand);
}
