

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

/**
 * The test class TestCoffeeShopSim.
 *
 * @Richard Phan
 * @March 15, 2019
 */
public class TestCoffeeShopSim
{
    /**
     * Default constructor for test class TestCoffeeShopSim
     */
    public TestCoffeeShopSim()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }
    
    /**
     * Tests the normal boundary condition for the findMaxWait() method from the CoffeeShopSim class
     */
    @Test
    public void TestFindMaxTimeNC1() {
        CoffeeShopSim CSS = new CoffeeShopSim();
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(0);
        list.add(500);
        list.add(9);
        
        int theAns = CSS.findMaxWait(list);
        int trueAns = 500;
        
        assertEquals(theAns, trueAns);
    }
    
    /**
     * Tests the normal boundary condition for the findMaxWait() method from the CoffeeShopSim class
     */
    @Test
    public void TestFindMaxTimeNC2() {
        CoffeeShopSim CSS = new CoffeeShopSim();
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(15);
        list.add(3);
        
        int theAns = CSS.findMaxWait(list);
        int trueAns = 15;
        
        assertEquals(theAns, trueAns);
    }
    
    /**
     * Tests the boundary condition for the findMaxWait() method from the CoffeeShopSim class
     */
    @Test
    public void TestFindMaxTimeBC1() {
        CoffeeShopSim CSS = new CoffeeShopSim();
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(20);
        list.add(4);
        list.add(9);
        
        int theAns = CSS.findMaxWait(list);
        int trueAns = 20;
        
        assertEquals(theAns, trueAns);
    }
    
    /**
     * Tests the boundary condition for the findMaxWait() method from the CoffeeShopSim class
     */
    @Test
    public void TestFindMaxTimeBC2() {
        CoffeeShopSim CSS = new CoffeeShopSim();
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(1);
        list.add(1000);
        
        int theAns = CSS.findMaxWait(list);
        int trueAns = 1000;
        
        assertEquals(theAns, trueAns);
    }
    
    /**
     * Tests the invalid boundary condition for the findMaxWait() method from the CoffeeShopSim class
     */
    public void TestFindMaxTimeIBC() {
        CoffeeShopSim CSS = new CoffeeShopSim();
        ArrayList<String> list = new ArrayList<String>();
        list.add("l");
        list.add("df");
        list.add("wer");
        
        //Invalid ArrayList type in the parameter
        //int theAns = CSS.findMaxWait(list);
        int trueAns = 500;
        
        //assertEquals(theAns, trueAns);
    }
    
    /**
     * Tests the normal boundary condition for the avgWait() method from the CoffeeShopSim class
     */
    @Test
    public void TestAvgWaitTimeNC1() {
        CoffeeShopSim CSS = new CoffeeShopSim();
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(24);
        list.add(5);
        list.add(1);
        
        int theAns = CSS.avgWait(list);
        int trueAns = 10;
        
        assertEquals(theAns, trueAns);
    }
    
    /**
     * Tests the normal boundary condition for the avgWait() method from the CoffeeShopSim class
     */
    @Test
    public void TestAvgWaitTimeNC2() {
        CoffeeShopSim CSS = new CoffeeShopSim();
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(19);
        list.add(6);
        list.add(20);
        
        int theAns = CSS.avgWait(list);
        int trueAns = 15;
        
        assertEquals(theAns, trueAns);
    }
    
    /**
     * Tests the boundary condition for the avgWait() method from the CoffeeShopSim class
     */
    @Test
    public void TestAvgWaitTimeBC1() {
        CoffeeShopSim CSS = new CoffeeShopSim();
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(23);
        
        int theAns = CSS.avgWait(list);
        int trueAns = 23;
        
        assertEquals(theAns, trueAns);
    }
    
    /**
     * Tests the boundary condition for the avgWait() method from the CoffeeShopSim class
     */
    @Test
    public void TestAvgWaitTimeBC2() {
        CoffeeShopSim CSS = new CoffeeShopSim();
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(0);
        list.add(5);
        list.add(5);
        list.add(10);
        list.add(1000);
        
        int theAns = CSS.avgWait(list);
        int trueAns = 204;
        
        assertEquals(theAns, trueAns);
    }
    
    /**
     * Tests the invalid boundary condition for the avgWait() method from the CoffeeShopSim class
     */
    public void TestAvgWaitTimeIBC() {
        CoffeeShopSim CSS = new CoffeeShopSim();
        ArrayList<String> list = new ArrayList<String>();
        list.add("g");
        list.add("T");
        list.add("s");
        
        //Invalid ArrayList type in parameter
        //int theAns = CSS.avgWait(list);
        int trueAns = 10;
        
        //assertEquals(theAns, trueAns);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
