package io.turntabl;

import io.turntabl.main.Card;
import io.turntabl.main.Deck;
import io.turntabl.main.Game;

import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.print("Enter Number Of Players: ");

        int numberOfPlayers = myObj.nextInt();  // Read user input

        Game game = new Game(numberOfPlayers);
        game.start();
    }
}
