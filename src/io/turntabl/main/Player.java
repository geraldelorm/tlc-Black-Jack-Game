package io.turntabl.main;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final Integer ID;
    private List<Card> cards;
    private Strategy currStrategy;

    public Player(Integer id) {
        ID = id;
        cards = new ArrayList<>();
        currStrategy = Strategy.none;
    }

    public List<Card> getCards() {
        return cards;
    }

    public Integer getID() {
        return ID;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public Strategy getCurrStrategy() {
        return currStrategy;
    }

    public void setCurrStrategy(Strategy currStrategy) {
        this.currStrategy = currStrategy;
    }

    public Integer getCardsValue() {
        Integer sum = 0;
        if (cards.isEmpty()) return sum;


        for(Card card : cards) {
            sum += card.getValue().getValue();
        }

        return sum;
    }
}
