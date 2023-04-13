/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package blackjackv5;

import org.junit.Test;
import static org.junit.Assert.*;

public class SuitTest {

    @Test
    public void testGood() {
        Suit suit = Suit.CLUBS;
        assertEquals(Suit.CLUBS, suit);
    }

    @Test
    public void testBad() {
        Suit suit = Suit.SPADES;
        assertNotEquals(Suit.HEARTS, suit);
    }

    @Test
    public void testBoundary() {
        Suit suit = Suit.DIAMONDS;
        assertNotNull(suit);
    }
}
