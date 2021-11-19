package io.turntabl.main;

public enum Suit {
    heart("\u2665"), diamond("\u2666"), club("\u2667"), spade("\u2664");

    private final String unicode;
    Suit(String unicode) {
        this.unicode = unicode;
    }

    public String getUnicode () {
        return this.unicode;
    }
}
