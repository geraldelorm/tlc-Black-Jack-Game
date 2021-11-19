package io.turntabl.main;

import java.util.Collections;
import java.util.List;

public class Game {
    public boolean isStartGame = false;
    //    private List<Player> players;
    Player player1 = new Player(1);
    Player player2 = new Player(2);
    Player player3 = new Player(3);
    private final Deck deck;

    public Game() {
        this.deck = new Deck();
    }

    public void start(/*String[] args*/) {
        isStartGame = true;

        while (isStartGame) {
            // shuffle and deal two cards for each player
            System.out.println("----------- GAME STARTED ----------");
            System.out.println("------ WELCOME TO BLACK JACK ------");
            System.out.println("       :- by elorm and okai :-     ");
            System.out.println("       -----------------------     \n");
            System.out.println("############## Shuffling cards...");
            shuffleDeck();
            System.out.println("######## Cards Shuffled ########");

            System.out.println("##### Dealing card to player One");
            dealCard(2, player1);
            System.out.println("[+] Player One got dealt: " + printCards(player1));
            System.out.println("Player One's Total is: " + player1.getCardsValue() + "\n");


            System.out.println("##### Dealing card to player Two");
            dealCard(2, player2);
            System.out.println("[+] Player Two got dealt: " + printCards(player2));
            System.out.println("Player Two's Total is: " + player2.getCardsValue() + "\n");


            System.out.println("##### Dealing card to player Three");
            dealCard(2, player3);
            System.out.println("[+] Player Three got dealt: "+ printCards(player3));
            System.out.println("Player Three's Total is: " + player3.getCardsValue() + "\n");

            System.out.println("###### Players will now take turns ######" + "\n");

            System.out.println(getStrategy(player1));
            System.out.println(getStrategy(player2));
            System.out.println(getStrategy(player3));



//            stop game
            isStartGame = !isStartGame;

        }
    }

    public void shuffleDeck() {
        Collections.shuffle(deck.getCards());
    }

    public void dealCard(int number, Player player) {
        if (number <= 0) return;
        for (int i = 0; i < number; i++) {
            Card card = deck.getCards().remove(0);
            player.addCard(card);
        }
    }

    public String printCards(Player player) {
        List<Card> playerCards = player.getCards();

        StringBuilder cardDetails = new StringBuilder();
        for (Card card : playerCards) {
            cardDetails.append(card.getValue())
                    .append(card.getSuit().getUnicode())
                    .append(", ");
        }
        return cardDetails.toString();
    }

    public String getStrategy(Player player) {
        String action = "";
        if (player1.getCardsValue() < 17){
            action = "######## Player " + player.getID() + " will now hit";
            dealCard(1, player);
        } else if (player.getCardsValue() >= 17) {
            action = "######## Player " + player.getID() + " will now stick";
        } else if (player.getCardsValue() > 21) {
            action = "######## Player " + player.getID() + " s now bust";
            action += "**** Player " + player.getID() + " is out of the game *****";
        }
        return action;
    }

    public void playerNextMove(Player player1) {
      // depending on strategy
        // make a move i.e deal card, not deal card or get busted
    }
}
