

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

/**
 * The test class TestCustomer.
 *
 * @Richard Phan
 * @March 15, 2019
 */
public class TestCustomer
{
    /**
     * Default constructor for test class TestCustomer
     */
    public TestCustomer()
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
     * Tests the normal boundary condition of the getArriveT() method from the Customer class
     */
    @Test
    public void TestGetArrivalTimeNC1() {
        ArrayList<Customer> c = new ArrayList<Customer>();
        c.add(new Customer(150));
        c.add(new Customer(300));
        c.add(new Customer(2));
        
        int theAns = c.get(1).getArriveT();
        int trueAns = 300;
        
        assertEquals(theAns, trueAns);
    }
    
    /**
     * Tests the normal boundary condition of the getArriveT() method from the Customer class
     */
    @Test
    public void TestGetArrivalTimeNC2() {
        ArrayList<Customer> c = new ArrayList<Customer>();
        c.add(new Customer(3));
        c.add(new Customer(19));
        c.add(new Customer(1000));
        c.add(new Customer(15));
        
        int theAns = c.get(2).getArriveT();
        int trueAns = 1000;
        
        assertEquals(theAns, trueAns);
    }
    
    /**
     * Tests the boundary condition of the getArriveT() method from the Customer class
     */
    @Test
    public void TestGetArrivalTimeBC1() {
        ArrayList<Customer> c = new ArrayList<Customer>();
        c.add(new Customer(0));
        c.add(new Customer(1));
        c.add(new Customer(2));
        
        int theAns = c.get(0).getArriveT();
        int trueAns = 0;
        
        assertEquals(theAns, trueAns);
    }
    
    /**
     * Tests the boundary condition of the getArriveT() method from the Customer class
     */
    @Test
    public void TestGetArrivalTimeBC2() {
        ArrayList<Customer> c = new ArrayList<Customer>();
        c.add(new Customer(10));
        c.add(new Customer(9));
        c.add(new Customer(8));
        
        int theAns = c.get(2).getArriveT();
        int trueAns = 8;
        
        assertEquals(theAns, trueAns);
    }
    
    /**
     * Tests the invalid boundary condition of the getArriveT() method from the Customer class
     */
    public void TestGetArrivalTimeIBC() {
        ArrayList<Customer> c = new ArrayList<Customer>();
        c.add(new Customer(150));
        c.add(new Customer(300));
        c.add(new Customer(2));
        
        //Invalid because there is no third element in the ArrayList
        int theAns = c.get(3).getArriveT();
        int trueAns = 300;
        
        assertEquals(theAns, trueAns);
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
