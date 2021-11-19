package io.turntabl;

import io.turntabl.main.Card;
import io.turntabl.main.Deck;
import io.turntabl.main.Game;

import java.util.Collections;
import java.util.Scanner;

public class BlackJack {

    public static void main(String[] args) {
//        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
//        System.out.print("Enter Number Of Players: ");
//
//        int numberOfPlayers = myObj.nextInt();  // Read user input
        try {
            int numberOfPlayers = Integer.parseInt(args[0]);
            Game game = new Game(numberOfPlayers);
            game.start();
        } catch (Exception e) {
            System.out.println("Enter Arguments in this Format: java + io.turntabl.BlackJack + 'number of player e.g. 5' ");;
        }

    }
}