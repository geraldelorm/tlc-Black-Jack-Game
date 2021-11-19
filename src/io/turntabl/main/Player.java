package io.turntabl.main;

import java.util.ArrayList;
import java.util.List;

public class Player {


    private final Integer ID;
    private List<Card> cards;

    public Player(Integer id) {
        ID = id;
        cards = new ArrayList<>();
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

    public Integer getCardsValue() {
        Integer sum = 0;
        if (cards.isEmpty()) return sum;


        for(Card card : cards) {
            sum += card.getValue().getValue();
        }

        return sum;
    }
}
