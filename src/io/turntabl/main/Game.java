package io.turntabl.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    private final Deck deck;
    private final List<Player> players;
    private boolean isStartGame = false;

    public Game() {
        this.deck = new Deck();
        this.players = new ArrayList<>();
        this.players.add(new Player(1));
        this.players.add(new Player(2));
        this.players.add(new Player(3));
    }

    public void start(/*String[] args*/) {
        isStartGame = true;

        displayIntro();
        shuffleDeck();

        System.out.println("##### Dealing card to players"+ "\n");
        for (Player player : players) {
            dealCard(2, player);
        }

        checkGameStatus();

        while (isStartGame) {

            System.out.println("###### Players are taking turns now... ######" + "\n");

            for (Player player : players) {
                playerNextMove(player);
            }

            checkGameStatus();
        }
    }

    private void shuffleDeck() {
        Collections.shuffle(deck.getCards());
        System.out.println("######## Cards Shuffled ########");
    }

    private void dealCard(int number, Player player) {
        if (number <= 0) return;
        for (int i = 0; i < number; i++) {
            Card card = deck.getCards().remove(0);
            player.addCard(card);
        }

        System.out.println("[+] Player " + player.getID() + " got dealt: " + printCards(player));
        System.out.println("Player " + player.getID() + " Total is: " + player.getCardsValue() + "\n");
    }

    private String printCards(Player player) {
        List<Card> playerCards = player.getCards();

        StringBuilder cardDetails = new StringBuilder();
        for (Card card : playerCards) {
            cardDetails.append(card.getValue())
                    .append(card.getSuit().getUnicode())
                    .append(", ");
        }
        return cardDetails.toString();
    }

    private void changePlayerStrategy(Player player) {
        if (player.getCardsValue() < 17) {
            System.out.println("######## Player " + player.getID() + " will now hit");
            player.setCurrStrategy(Strategy.hit);
        } else if (player.getCardsValue() > 21) {
            System.out.println("######## Player " + player.getID() + " s now bust");
            System.out.println("**** Player " + player.getID() + " is out of the game *****");
            player.setCurrStrategy(Strategy.goBust);
        } else if (player.getCardsValue() >= 17) {
            System.out.println("######## Player " + player.getID() + " will now stick");
            player.setCurrStrategy(Strategy.stick);
        }
    }

    private void playerNextMove(Player player) {
        changePlayerStrategy(player);
        switch (player.getCurrStrategy()) {
            case hit:
                dealCard(1, player);
                break;
            case stick:
                // do nothing
                break;
            case goBust:
                players.remove(player);
                break;
        }
    }

    private void displayIntro() {
        System.out.println("----------- GAME STARTED ----------");
        System.out.println("------ WELCOME TO BLACK JACK ------");
        System.out.println("       :- by elorm and okai :-     ");
        System.out.println("       -----------------------    \n");
        System.out.println("############## Shuffling cards...");
    }

    private void checkGameStatus() {
        List<Player> stickPlayers = players.stream()
                .filter(player -> player.getCurrStrategy() == Strategy.stick)
                .toList();

        List<Player> playersHit21 = players.stream().filter(player -> player.getCardsValue() == 21).toList();

        if (stickPlayers.size() == players.size()) {
            System.out.println("############ ALL PLAYERS STICK ###########");
            Player winner = players.stream().max((player1, player2) -> maxComparator(player1, player2)).get();
            System.out.println("############# GAME WINNER IS PLAYER "+ winner.getID() +" ##############");
            System.out.println("############# GAME HAS ENDED ##############");
            isStartGame = false;
        } else if (!playersHit21.isEmpty()) {
            for (Player player: playersHit21 ) {
                System.out.println("############# GAME WINNER IS PLAYER "+ player.getID() +" ##############");
            }
            System.out.println("################# GAME HAS ENDED ###############");
            isStartGame = false;
        } else if (players.size() == 1) {
            Player winner = players.get(0);
            System.out.println("############# GAME WINNER IS PLAYER "+ winner.getID() +" ##############");
            System.out.println("############# GAME HAS ENDED ##############");
            isStartGame = false;
        }else if (players.size() == 0) {
            System.out.println("############# ALL PLAYERS GOT BUSTED ##############");
            System.out.println("############# GAME HAS ENDED ##############");
            isStartGame = false;
        }
    }

    int maxComparator(Player player1, Player player2) {
        if (player1.getCardsValue() > player2.getCardsValue()) return 1;
        if (player1.getCardsValue() < player2.getCardsValue()) return -1;
        else return 0;
    }

    /*
    player has a curStrategy=Strategy.none
    playerNextMove()-> assign the strategy to curStategy of player
    filter players strategy for stick only and then compare to the list of players
        if they're same exit game, the winner the one who has a value closer to 21+
        else continue
     */
}
