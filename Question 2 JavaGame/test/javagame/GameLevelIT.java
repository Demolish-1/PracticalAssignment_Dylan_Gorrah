/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package javagame;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Dylan
 */
public class GameLevelIT {
    
    public GameLevelIT() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of play method, of class GameLevel.
     */
    @Test
    public void testPlay() {
        System.out.println("play");
        GameLevel instance = null;
        instance.play();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaxNumber method, of class GameLevel.
     */
    @Test
    public void testGetMaxNumber() {
        System.out.println("getMaxNumber");
        GameLevel instance = null;
        int expResult = 0;
        int result = instance.getMaxNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class GameLevelImpl extends GameLevel {

        public GameLevelImpl() {
            super(0, 0);
        }

        public int getMaxNumber() {
            return 0;
        }
    }

    public class GameLevelImpl extends GameLevel {

        public GameLevelImpl() {
            super(0, 0);
        }

        public int getMaxNumber() {
            return 0;
        }
    }
    
}
