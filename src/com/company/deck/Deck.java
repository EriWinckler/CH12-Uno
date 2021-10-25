package com.company.deck;


import java.util.ArrayList;
import java.util.List;

public interface Deck {
    void shuffle();
    Card draw(ArrayList deck);
    Card setColor(Card playedCard, String color);
    int size();
}
