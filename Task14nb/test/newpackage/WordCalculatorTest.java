/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vet
 */
public class WordCalculatorTest {
    
    public WordCalculatorTest() {
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
     * Test of calculateAll method, of class WordCalculator.
     */
    @Test
    public void testCalculateAll() {
     /*   System.out.println("calculateAll");
        String s = "";
        int[] expResult = null;
        int[] result = WordCalculator.calculateAll(s);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        
        
        */
     assertTrue(WordCalculator.calculateAll("xxx xxx, xx")[0]==3);
     assertTrue(WordCalculator.calculateAll("xxx xxx, xx")[1]==8);
     assertTrue(WordCalculator.calculateAll("    xxx,    xx x   x")[0]==4);
     assertTrue(WordCalculator.calculateAll("    xxx,    xx x   x")[1]==7);
     assertTrue(WordCalculator.calculateAll("xxxxxxx")[0]==1);
     assertTrue(WordCalculator.calculateAll("xxxxxxx")[1]==7);
     assertTrue(WordCalculator.calculateAll("xxxxxxx.    ")[0]==1);
     assertTrue(WordCalculator.calculateAll("xxxxxxx.    ")[1]==7);
     assertTrue(WordCalculator.calculateAll("xxx,xxxx")[0]==2);
     assertTrue(WordCalculator.calculateAll("xxx,xxxx")[1]==7);
     assertTrue(WordCalculator.calculateAll("........")[0]==0);
     assertTrue(WordCalculator.calculateAll("........")[1]==0);
     assertTrue(WordCalculator.calculateAll("... xxx...")[0]==1);
     assertTrue(WordCalculator.calculateAll("... xxx...")[1]==3);
     assertTrue(WordCalculator.calculateAll("")[0]==0);
     assertTrue(WordCalculator.calculateAll("")[1]==0);
    // int[] a={2,7};
     //assertEquals(WordCalculator.calculateAll("xxx,xxxx"),a);
     
     
    }

    /**
     * Test of main method, of class WordCalculator.
     */
   /* @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        WordCalculator.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    
}
