package io.turntabl.test;

import io.turntabl.main.Deck;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeckTest {
    Deck deck = new Deck();

    @Test
    void testNumberOfCardsInADeck() {
        assertEquals(52, (int) deck.getNumberOfCards());
    }

    /*
    removeCard(index)
     */

}
