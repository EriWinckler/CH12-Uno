package com.company.deck;


import java.util.List;

public interface Deck {
    void shuffle();
    Card draw();
    List drawAll();
    Card setColor(Card playedCard, String color);
}
