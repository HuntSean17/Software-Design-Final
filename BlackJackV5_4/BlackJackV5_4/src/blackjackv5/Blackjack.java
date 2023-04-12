/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package blackjackv5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author todds
 */
public class Blackjack {
    public static void main(String[] args) {
        // Create a list of players
        List<Player> players = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of players (1-5): ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= numPlayers; i++) {
            System.out.print("Enter name for player " + i + ": ");
            String name = scanner.nextLine();
            Player player = new Player(name);
            players.add(player);
        }

        // Create a game with the list of players
        Game game = new Game(players);

        // Start the game
        game.play();
    }
}
