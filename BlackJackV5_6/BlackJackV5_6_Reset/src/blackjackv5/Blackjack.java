
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
        Scanner scanner = new Scanner(System.in);

        // Create the list of players
        List<Player> players = new ArrayList<>();
        System.out.print("Enter the number of players (1-5): ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= numPlayers; i++) {
            System.out.print("Enter name for player " + i + ": ");
            String name = scanner.nextLine();

            System.out.print("Enter starting bank value for " + name + ": ");
            int bank = scanner.nextInt();
            scanner.nextLine();

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
