/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package blackjackv5;
import org.junit.Test;
import static org.junit.Assert.*;

public class RankTest {
    
    @Test
    public void testGetValueGood() {
        Rank rank = Rank.KING;
        int expResult = 10;
        int result = rank.getValue();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetValueBad() {
        Rank rank = Rank.TWO;
        int expResult = 5; // incorrect expected value
        int result = rank.getValue();
        assertNotEquals(expResult, result);
    }
    
    @Test
    public void testGetValueBoundary() {
        Rank rank = Rank.ACE;
        int expResult = 1;
        int result = rank.getValue();
        assertEquals(expResult, result);
    }
}
