package io.turntabl;

import io.turntabl.main.Game;

public class BlackJack {

    public static void main(String[] args) {
//        USING USER INPUT
//        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
//        System.out.print("Enter Number Of Players: ");
//
//        int numberOfPlayers = myObj.nextInt();  // Read user input

//        USING CLI ARGUMENTS
        try {
            int numberOfPlayers = Integer.parseInt(args[0]);
            Game game = new Game(numberOfPlayers);
            game.start();
        } catch (Exception e) {
            System.out.println("Enter Arguments in this Format: java + io.turntabl.BlackJack + 'number of player e.g. 5' ");;
        }

    }
}
