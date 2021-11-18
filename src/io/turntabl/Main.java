package io.turntabl;

import io.turntabl.main.Card;
import io.turntabl.main.Deck;

import java.util.Collections;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("hey");
        Deck deck = new Deck();
        int random = (int) (Math.random() * (52 - 2) + 1);

        System.out.println(deck); // not shuffled
        Collections.shuffle(deck.getCards());
        System.out.println(deck); // shuffled
//        System.out.println(deck.getCards().get(random));

        Card card = deck.getCards().get(random);
        System.out.println(card);
        System.out.println(card.getValue());
        System.out.println(card.getValue().getValue());
    }
}
