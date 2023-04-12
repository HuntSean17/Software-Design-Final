/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjackv5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private final CardDeck deck;
    private final List<Player> players;
    private int dealerScore;

    public Game(List<Player> players) {
        deck = new CardDeck();
        deck.shuffle();
        this.players = players;
        dealerScore = 0;
    }

    public void play() {
        System.out.println("Welcome to Blackjack!");
        dealCards();
        showCards(false);
        for (Player player : players) {
            boolean playerBust = playerTurn(player);
            if (playerBust) {
                System.out.println(player.getName() + " busted! Dealer wins!");
            } else {
                System.out.println(player.getName() + "'s turn is over.");
            }
        }
        dealerTurn();
        determineWinners();
    }

    private void dealCards() {
        for (Player player : players) {
            Card card1 = deck.drawCard();
            Card card2 = deck.drawCard();
            player.addToScore(card1.getValue() + card2.getValue());
            System.out.println(player.getName() + " was dealt a " + card1 + " and a " + card2);
        }
        Card card3 = deck.drawCard();
        Card card4 = deck.drawCard();
        dealerScore = card3.getValue() + card4.getValue();
        System.out.println("Dealer's card: " + card3);
    }

    private void showCards(boolean showDealerCard) {
        for (Player player : players) {
            System.out.println(player.getName() + "'s score: " + player.getScore());
        }
        if (showDealerCard) {
            System.out.println("Dealer's score: " + dealerScore);
        } else {
            System.out.println("Dealer's card: [hidden]");
        }
    }

    private boolean playerTurn(Player player) {
        Scanner scanner = new Scanner(System.in);
        while (player.getScore() <= 21) {
            System.out.print(player.getName() + ", hit or stand? ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("hit")) {
                Card card = deck.drawCard();
                player.addToScore(card.getValue());
                System.out.println(player.getName() + " drew a " + card);
                System.out.println(player.getName() + "'s score is now " + player.getScore());
            } else if (input.equalsIgnoreCase("stand")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter 'hit' or 'stand'.");
            }
        }
        return true;
    }
     private void dealerTurn() {
        System.out.println("Dealer's turn...");
        while (dealerScore < 17) {
            Card card = deck.drawCard();
            dealerScore += card.getValue();
            System.out.println("Dealer draws a " + card);
            System.out.println("Dealer's score is now " + dealerScore);
        }
    }

    private void determineWinners() {
    System.out.println("All turns are over. Determining winners...");
    System.out.println("Dealer's score: " + dealerScore);
    for (Player player : players) {
        if (player.getScore() > 21) {
            System.out.println(player.getName() + " busted! Dealer wins!");
        } else if (dealerScore > 21) {
            System.out.println("Dealer busted! " + player.getName() + " wins!");
        } else if (player.getScore() > dealerScore) {
            System.out.println(player.getName() + " wins!");
        } else if (dealerScore > player.getScore()) {
            System.out.println("Dealer wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }
}

}
   
