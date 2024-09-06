/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnitTestClass.java to edit this template
 */
package javagame;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Dylan
 */
public class EasyLevelIT {
    
    public EasyLevelIT() {
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

    /**
     * Test of getMaxNumber method, of class EasyLevel.
     */
    @Test
    public void testGetMaxNumber() {
        System.out.println("getMaxNumber");
        EasyLevel instance = new EasyLevel();
        int expResult = 0;
        int result = instance.getMaxNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
    
}