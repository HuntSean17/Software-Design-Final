/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjackv5;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void testSetAndGetBankGood() {
        Player player = new Player("Alice", 100);
        int expResult = 200;
        int result = player.setBank(100);
        assertEquals(expResult, result);
        expResult = 300;
        result = player.setBank(100);
        assertEquals(expResult, result);
    }
    @Test
    public void testSetAndGetBankBad() {
        Player player = new Player("Bob", 50);
        int amountToAdd = 25;
        int expectedBankValue = player.getBank() + amountToAdd;
        boolean success = player.setBank(amountToAdd) == expectedBankValue;
        assertTrue(success);
    }


    @Test
    public void testSetAndGetBankBoundary() {
        Player player = new Player("Charlie", 500);
        int expResult = 501;
        int result = player.setBank(1);
        assertEquals(expResult, result);
    }
}