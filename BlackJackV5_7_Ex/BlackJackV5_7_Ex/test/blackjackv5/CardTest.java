/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package blackjackv5;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Desi
 */
public class CardTest {
    
    public CardTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetValueGood() {
        Card card = new Card(Suit.HEARTS, Rank.KING);
        int expResult = 10;
        int result = card.getValue();
        assertEquals(expResult, result);
    }
    @Test
    public void testGetValueBad() {
        Card card = new Card(Suit.SPADES, Rank.QUEEN);
        int expResult = 5; // incorrect expected value
        int result = card.getValue();
        assertNotEquals(expResult, result);
    }

    @Test
    public void testGetValueBoundary() {
        Card card = new Card(Suit.CLUBS, Rank.TWO);
        int expResult = 2;
        int result = card.getValue();
        assertEquals(expResult, result);
    }
}
