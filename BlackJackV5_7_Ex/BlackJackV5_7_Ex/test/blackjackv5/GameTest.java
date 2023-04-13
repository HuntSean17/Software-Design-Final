/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjackv5;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class GameTest {

    @Test
    public void testGoodValues() {
        List<Player> players = new ArrayList<>();
        players.add(new Player("Alice", 50));
        players.add(new Player("Bob", 100));
        Game game = new Game(players);
    }

    @Test
    public void testBadValues() {
        List<Player> players = new ArrayList<>();
        players.add(new Player("Alice", 0));
        players.add(new Player("Bob", 0));
        Game game = new Game(players);
    }
    @Test
    public void testBoundaryValues() {
        List<Player> players = new ArrayList<>();
        players.add(new Player("Alice", Integer.MAX_VALUE));
        players.add(new Player("Bob", 1));
        Game game = new Game(players);
}

}


