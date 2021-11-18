package io.turntabl.test;

import io.turntabl.main.Card;
import io.turntabl.main.Suit;
import io.turntabl.main.Value;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardTest {
    Card card = new Card(Suit.diamond, Value.two);

    @Test
    void testCardSuit() {
        Suit suit = Suit.diamond;
        assertEquals(suit, card.getSuit());
    }

    @Test
    void testCardValue() {
        Value value = Value.two;
        assertEquals(value, card.getValue());
    }
}
