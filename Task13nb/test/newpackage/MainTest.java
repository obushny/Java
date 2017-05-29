/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

//import static newpackage.Main.checkBracket;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Виталий
 */
public class MainTest {
    
    public MainTest() {
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
     * Test of main method, of class Main.
     */
   /* @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Main.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of checkBracket method, of class Main.
     */
    @Test
    public void testCheckBracket() {
        /*System.out.println("checkBracket");
        String formula = "";
        Main instance = new Main();
        instance.checkBracket(formula);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
        
        //instance.checkBracket("(())");
        assertFalse(Bracket.checkBracket("(a(b)c)d)"));
        assertTrue(Bracket.checkBracket("(())"));  
        assertFalse(Bracket.checkBracket(")(()"));  
        assertFalse(Bracket.checkBracket("((())))"));  
        assertFalse(Bracket.checkBracket("((())"));  
        assertTrue(Bracket.checkBracket(""));
        
        assertTrue(Bracket.checkBracket("()()()"));
        assertTrue(Bracket.checkBracket("()(())"));
        assertFalse(Bracket.checkBracket(")("));
        assertTrue(Bracket.checkBracket("(()())"));
        assertTrue(Bracket.checkBracket(""));
        assertFalse(Bracket.checkBracket("((())"));
        assertFalse(Bracket.checkBracket("(()))"));
        
        
    }
    
}
