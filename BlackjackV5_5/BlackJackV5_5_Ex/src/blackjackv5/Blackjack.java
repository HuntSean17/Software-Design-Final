
package blackjackv5;

/**
 *
 * @author todds
 */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

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
                player.clearCards();
                player.resetScore();
            }
            game = new Game(players);
            game.play();
        }
        
        
        
    }
}
