package blackjackv5;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BlackjackTest {
    
    public BlackjackTest() {
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
    public void testPlayerCreationGood() {
        Player player = new Player("Alice", 100);
        assertEquals("Alice", player.getName());
        assertEquals(100, player.getBank());
    }

    @Test
    public void testPlayerCreationBoundary() {
        Player player = new Player("Bob", 0);
        assertEquals("Bob", player.getName());
        assertEquals(0, player.getBank());
    }

    @Test
    public void testPlayerCreationBad() {
        Player player = new Player("", -100);
        assertEquals("", player.getName());
        assertEquals(-100, player.getBank());
    }
}
