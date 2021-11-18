package io.turntabl.main;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private List<Card> cards;

    @Override
    public String toString() {
        return "Deck{" +
                "cards=" + cards +
                '}';
    }

    public Deck() {
        this.cards =  new ArrayList<>();
        /*
        generate cards
        for suit in Suit.values() -> 4
            for value in Value.values() -> 13
                add a 'card' to 'cards'
         */
        for(Suit suit: Suit.values()) {
            for (Value value: Value.values()){
                cards.add(new Card(suit, value));
            }
        }

    }
    public Integer getNumberOfCards(){
        return cards.size();
    }

    public List<Card> getCards() {
        return cards;
    }
}

