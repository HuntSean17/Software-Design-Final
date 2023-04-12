
package blackjackv5;

/**
 * V5_1 - basic game with no players class, bank balance or betting, single
 * loop
 * 
 * V5_4 - added player class, single loop
 * 
 * V5_5 - added bank balance and betting, main displays proper bank 
 * balance but does not update value in player class, single loop
 * 
 * V5_5_Ex - added exception handling to main argument, single loop
 * 
 * V5_6_Reset - added looping to main argument so that players can be reuse
 * names and bank balance and that game can continue until users decides 
 * to quit
 * 
 * V5_7EX - added exception handling to main argument (again) - was removed by
 * accident in V5_6_Reset
 * 
 * V5_8 - updated player class to confirm users has funds to make bet and
 * to purchase more chips if balance is less than zero
 * 
 * V5_9 - added player stats when game is exited
 * 
 */

import java.util.*;


public class Blackjack {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int numPlayers = 0;
        boolean validNumPlayers = false;
        while (!validNumPlayers) {
            System.out.print("Enter the number of players (1-5): ");
            try {
                numPlayers = scanner.nextInt();
                scanner.nextLine();
                if (numPlayers < 1 || numPlayers > 5) {
                    throw new InputMismatchException();
                }
                validNumPlayers = true;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
            }
        }

        for (int i = 1; i <= numPlayers; i++) {
            String name = "";
            boolean validName = false;
            while (!validName) {
                System.out.print("Enter name for player " + i + ": ");
                name = scanner.nextLine();
                if (name.equals("")) {
                    System.out.println("Invalid input. Please enter a valid name.");
                } else {
                    validName = true;
                }
            }

            int bank = 0;
            boolean validBank = false;
            while (!validBank) {
                System.out.print("Enter starting bank value for " + name + ": ");
                try {
                    bank = scanner.nextInt();
                    scanner.nextLine();
                    if (bank < 0) {
                        throw new InputMismatchException();
                    }
                    validBank = true;
                } catch (InputMismatchException e) {
                    scanner.nextLine();
                    System.out.println("Invalid input. Please enter a positive integer.");
                }
            }

            Player player = new Player(name, bank);
            players.add(player);
        }

        // Create the initial game
        Game game = new Game(players);
        game.play();

        // Reset the game
        while (true) {
            System.out.print("Play again? (y/n): ");
            String input = scanner.nextLine();
            if (!input.equalsIgnoreCase("y")) {
                break;
            }

            // Create a new game with the same players
            for (Player player : players) {
               // player.clearCards();
                player.setScore(0);
            }
            game = new Game(players);
            game.play();
        }
    }
}
