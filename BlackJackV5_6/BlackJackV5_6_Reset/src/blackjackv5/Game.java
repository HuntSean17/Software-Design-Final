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

        // Betting round
        for (Player player : players) {
            Scanner scanner = new Scanner(System.in);
            int maxBet = player.getScore();
            if (maxBet == 0) {
                maxBet = 1;
            }
            System.out.print(player.getName() + ", enter your bet (1-" + maxBet + "): ");
            int bet = scanner.nextInt();
            player.setBet(bet);
            scanner.nextLine(); // consume the newline character
        }

        // Deal cards
        dealCards();
        showCards(false);

        // Player turns
        for (Player player : players) {
            boolean playerBust = playerTurn(player);
            if (playerBust) {
                System.out.println(player.getName() + " busted! Dealer wins!");
            } else {
                System.out.println(player.getName() + "'s turn is over.");
            }
        }

        // Dealer turn
        dealerTurn();

        // Determine winners
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
            System.out.println(player.getName() + "'s bet: " + player.getBet());
        }
        if (showDealerCard) {
            System.out.println("Dealer's score: " + dealerScore);
        } else {
            System.out.println("Dealer's card: [hidden]");
        }
    }
private boolean playerTurn(Player player) {
    Scanner scanner = new Scanner(System.in);
    System.out.println(player.getName() + "'s turn...");
    while (true) {
        System.out.println(player.getName() + " your current score is " + player.getScore() + ", do you want to hit or stand? (h/s)");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("h")) {
            Card card = deck.drawCard();
            player.addToScore(card.getValue());
            System.out.println(player.getName() + " draws a " + card);
            System.out.println(player.getName() + "'s score is now " + player.getScore());
            if (player.getScore() > 21) {
                return true;
            }
        } else if (choice.equalsIgnoreCase("s")) {
            break;
        }
    }
    return false;
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
        int balance =0;
        System.out.println("All turns are over. Determining winners...");
        System.out.println("Dealer's score: " + dealerScore+"\n");
        for (Player player : players) {
            if (player.getScore() > 21) {
                
                System.out.println(player.getName() + " busted so the Dealer wins!");
                System.out.println(player.getName() +" bet $" + player.getBet() 
                         + " - their new bank balance is : $" + (player.getBank()-player.getBet()) +"\n");
         
               //System.out.println("getBank "+ player.getBank());
               // System.out.println("getBet " + player.getBet());
             
                player.setBank(player.getBet()*-1);
               //System.out.println(player.getBank());
                 
                 
            } else if (dealerScore > 21) {
                System.out.println("Dealer busted! " + player.getName() + " wins " + player.getBet() + " dollars!");
                System.out.println(player.getName() + " has a new bank balance of :" + (player.getBank()+player.getBet()));
                
               // System.out.println("getBank "+ player.getBank());
               // System.out.println("getBet " + player.getBet());
                
                player.setBank(player.getBet());
               // System.out.println(player.getBank());
                
                
            } else if (player.getScore() > dealerScore) {
                System.out.println(player.getName() + " wins " + player.getBet() + " dollars!");
                System.out.println(player.getName() + " has a new bank balance of :" + (player.getBank()+player.getBet()));
                
               // System.out.println("getBank "+ player.getBank());
            //    System.out.println("getBet " + player.getBet());
                
                player.setBank(player.getBet());
               // System.out.println(player.getBank());
                 
                 
            } else if (dealerScore > player.getScore()) {
                System.out.println("Dealer wins and " + player.getName() + " loses " + player.getBet() + " dollars!");
                System.out.println(player.getName() + " has a new bank balance of :" + (player.getBank()-player.getBet()));
         
              //  System.out.println("getBank "+ player.getBank());
             //   System.out.println("getBet " + player.getBet());
                player.setBank(player.getBet()*-1);
             //   System.out.println(player.getBank());
                
                
            } else {
                System.out.println("It's a tie! " + player.getName() + " gets back their bet of " + player.getBet() + " dollars.");
               
                System.out.println("getBank "+ player.getBank());
                System.out.println("getBet " + player.getBet());
                System.out.println(" the new balance is" + player.getBank());
                System.out.println(player.getBank());
            }
        }
    }
}
