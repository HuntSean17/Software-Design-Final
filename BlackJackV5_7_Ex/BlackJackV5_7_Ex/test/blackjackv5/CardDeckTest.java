package blackjackv5;

import org.junit.Test;
import static org.junit.Assert.*;

public class CardDeckTest {
    
    @Test
    public void testSizeGood() {
        CardDeck deck = new CardDeck();
        int expectedSize = 52;
        assertEquals(expectedSize, deck.size()); 
    }
    
    @Test
    public void testSizeBad() {
        CardDeck deck = new CardDeck();
        int expectedSize = 51; 
        int actualSize = deck.size();
        assertFalse(expectedSize == actualSize); 
    }
    @Test
    public void testSizeBoundary() {
        CardDeck deck = new CardDeck();
        int initialSize = deck.size();
        for (int i = 0; i < initialSize; i++) {
            deck.drawCard();
        }
        int finalSize = deck.size();
        assertEquals(0, finalSize);
    }
    
    @Test
    public void testShuffleGood() {
        CardDeck deck = new CardDeck();
        int sizeBeforeShuffle = deck.size();
        deck.shuffle();
        int sizeAfterShuffle = deck.size();
        assertEquals(sizeBeforeShuffle, sizeAfterShuffle); 
    }
    @Test
    public void testShuffleBad() {
        CardDeck deck = new CardDeck();
        deck.shuffle();
        Card firstCardBeforeShuffle = new Card(Suit.HEARTS, Rank.ACE);
        Card firstCardAfterShuffle = deck.drawCard();
        assertFalse(firstCardBeforeShuffle.equals(firstCardAfterShuffle)); 
    }
    
    @Test
    public void testShuffleBoundary() {
        CardDeck deck = new CardDeck();
        deck.shuffle();
        Card firstCardBeforeShuffle = new Card(Suit.HEARTS, Rank.ACE);
        Card firstCardAfterShuffle = deck.drawCard();
        assertFalse(firstCardBeforeShuffle.equals(firstCardAfterShuffle)); 
    }

}
