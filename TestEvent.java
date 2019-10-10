

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

/**
 * The test class TestEvent.
 *
 * @Richard Phan
 * @March 15, 2019
 */
public class TestEvent
{
    /**
     * Default constructor for test class TestEvent
     */
    public TestEvent()
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
     * Tests the normal boundary condition for the getCustomer() method of the Event class
     */
    @Test
    public void TestGetCustomerNC1() {
        Customer c = new Customer(0);
        Event e = new Event(0, 1, c);
        
        Customer theAns = e.getCustomer();
        Customer trueAns = c;
        
        assertEquals(theAns, trueAns);
    }
    
    /**
     * Tests the normal boundary condition for the getCustomer() method of the Event class
     */
    @Test
    public void TestGetCustomerNC2() {
        Customer c = new Customer(5000);
        Event e = new Event(5000, 1, c);
        
        Customer theAns = e.getCustomer();
        Customer trueAns = c;
        
        assertEquals(theAns, trueAns);
    }
    
    /**
     * Tests the boundary condition for the getCustomer() method of the Event class
     */
    @Test
    public void TestGetCustomerBC1() {
        Customer c = new Customer(40);
        ArrayList<Event> ev = new ArrayList<Event>();
        ev.add(new Event(40,1, c));
        ev.add(new Event(60,2, new Customer(60)));
        ev.add(new Event(100, 1, new Customer(100)));
        
        Customer theAns = ev.get(0).getCustomer();
        Customer trueAns = c;
        
        assertEquals(theAns, trueAns);
    }
    
    /**
     * Tests the boundary condition for the getCustomer() method of the Event class
     */
    @Test
    public void TestGetCustomerBC2() {
        Customer c = new Customer(100);
        ArrayList<Event> ev = new ArrayList<Event>();
        ev.add(new Event(40,1, new Customer(40)));
        ev.add(new Event(60,2, new Customer(60)));
        ev.add(new Event(100, 1, c));
        
        Customer theAns = ev.get(2).getCustomer();
        Customer trueAns = c;
        
        assertEquals(theAns, trueAns);
    }
    
    /**
     * Tests the invalid boundary condition for the getCustomer() method of the Event class
     */
    public void TestGetCustomerIBC() {
        Customer c = new Customer(0);
        ArrayList<Event> ev = new ArrayList<Event>();
        ev.add(new Event(40,1, c));
        ev.add(new Event(60,2, new Customer(60)));
        ev.add(new Event(100, 1, new Customer(100)));
        
        //The ArrayList doesn't have an index of 5
        Customer theAns = ev.get(5).getCustomer();
        Customer trueAns = c;
        
        assertEquals(theAns, trueAns);
    }
    
    /**
     * Tests the normal boundary condition for the setCustomer() method of the Event class
     */
    @Test
    public void TestSetCustomerNC1() {
        Customer c = new Customer(200);
        Event e = new Event(200, 1, new Customer(200));
        
        e.setCustomer(c);
        Customer theAns = e.getCustomer();
        Customer trueAns = c;
        
        assertEquals(theAns, trueAns);
    }
    
    /**
     * Tests the normal boundary condition for the setCustomer() method of the Event class
     */
    @Test
    public void TestSetCustomerNC2() {
        Customer c = new Customer(0);
        Event e = new Event(0, 1, new Customer(0));
        
        e.setCustomer(c);
        Customer theAns = e.getCustomer();
        Customer trueAns = c;
        
        assertEquals(theAns, trueAns);
    }
    
    /**
     * Tests the boundary condition for the setCustomer() method of the Event class
     */
    @Test
    public void TestSetCustomerBC1() {
        Customer c = new Customer(100);
        ArrayList<Event> ev = new ArrayList<Event>();
        ev.add(new Event(40,1, new Customer(40)));
        ev.add(new Event(60,2, new Customer(60)));
        ev.add(new Event(100, 1, new Customer(100)));
        
        ev.get(0).setCustomer(c);
        Customer theAns = ev.get(0).getCustomer();
        Customer trueAns = c;
        
        assertEquals(theAns, trueAns);
    }
    
    /**
     * Tests the boundary condition for the setCustomer() method of the Event class
     */
    @Test
    public void TestSetCustomerBC2() {
        Customer c = new Customer(90);
        ArrayList<Event> ev = new ArrayList<Event>();
        ev.add(new Event(1,1, new Customer(1)));
        ev.add(new Event(2,2, new Customer(2)));
        ev.add(new Event(3, 1, new Customer(3)));
        
        ev.get(2).setCustomer(c);
        Customer theAns = ev.get(2).getCustomer();
        Customer trueAns = c;
        
        assertEquals(theAns, trueAns);
    }
    
    /**
     * Tests the invalid boundary condition for the setCustomer() method of the Event class
     */
    public void TestSetCustomerIBC() {
        Customer c = new Customer(0);
        Event e = new Event(0, 1, new Customer(0));
        
        //Invalid data type
        //e.setCustomer(2);
        
        Customer theAns = e.getCustomer();
        Customer trueAns = c;
        
        assertEquals(theAns, trueAns);
    }
    
    /**
     * Tests the normal boundary condition for the getTime() method of the Event class
     */
    @Test
    public void TestGetTimeNC1() {
        Event e = new Event(0, 1, new Customer(0));
        
        int theAns = e.getTime();
        int trueAns = 0;
        
        assertEquals(theAns, trueAns);
    }
    
    /**
     * Tests the normal boundary condition for the getTime() method of the Event class
     */
    @Test
    public void TestGetTimeNC2() {
        Event e = new Event(19, 1, new Customer(0));
        
        int theAns = e.getTime();
        int trueAns = 19;
        
        assertEquals(theAns, trueAns);
    }
    
    /**
     * Tests the boundary condition for the getTime() method of the Event class
     */
    @Test
    public void TestGetTimeBC1() {
        ArrayList<Event> ev = new ArrayList<Event>();
        ev.add(new Event(1,1, new Customer(1)));
        ev.add(new Event(2,2, new Customer(2)));
        ev.add(new Event(3, 1, new Customer(3)));
        
        int theAns = ev.get(0).getTime();
        int trueAns = 1;
        
        assertEquals(theAns, trueAns);
    }
    
    /**
     * Tests the boundary condition for the getTime() method of the Event class
     */
    @Test
    public void TestGetTimeBC2() {
        ArrayList<Event> ev = new ArrayList<Event>();
        ev.add(new Event(10,1, new Customer(1)));
        ev.add(new Event(15,2, new Customer(2)));
        ev.add(new Event(20, 1, new Customer(3)));
        
        int theAns = ev.get(2).getTime();
        int trueAns = 20;
        
        assertEquals(theAns, trueAns);
    }
    
    /**
     * Tests the invalid boundary condition for the getTime() method of the Event class
     */
    public void TestGetTimeIBC() {
        ArrayList<Event> ev = new ArrayList<Event>();
        ev.add(new Event(1,1, new Customer(1)));
        ev.add(new Event(2,2, new Customer(2)));
        ev.add(new Event(3, 1, new Customer(3)));
        
        //Out of bounds index
        int theAns = ev.get(10).getTime();
        int trueAns = 19;
        
        assertEquals(theAns, trueAns);
    }
    
    /**
     * Tests the normal boundary condition for the getType() method of the Event class
     */
    @Test
    public void TestGetTypeNC1() {
        Event e = new Event(50, 1, new Customer(50));
        
        int theAns = e.getType();
        int trueAns = 1;
        
        assertEquals(theAns, trueAns);
    }
    
    /**
     * Tests the normal boundary condition for the getType() method of the Event class
     */
    @Test
    public void TestGetTypeNC2() {
        Event e = new Event(4, 2, new Customer(4));
        
        int theAns = e.getType();
        int trueAns = 2;
        
        assertEquals(theAns, trueAns);
    }
    
    /**
     * Tests the boundary condition for the getType() method of the Event class
     */
    @Test
    public void TestGetTypeBC1() {
        ArrayList<Event> ev = new ArrayList<Event>();
        ev.add(new Event(1,1, new Customer(1)));
        ev.add(new Event(2,2, new Customer(2)));
        ev.add(new Event(3, 1, new Customer(3)));
        
        
        int theAns = ev.get(0).getType();
        int trueAns = 1;
        
        assertEquals(theAns, trueAns);
    }
    
    /**
     * Tests the boundary condition for the getType() method of the Event class
     */
    @Test
    public void TestGetTypeBC2() {
        ArrayList<Event> ev = new ArrayList<Event>();
        ev.add(new Event(1,1, new Customer(1)));
        ev.add(new Event(2,2, new Customer(2)));
        ev.add(new Event(4, 2, new Customer(4)));
        
        int theAns = ev.get(2).getType();
        int trueAns = 2;
        
        assertEquals(theAns, trueAns);
    }
    
    /**
     * Tests the invalid boundary condition for the getType() method of the Event class
     */
    public void TestGetTypeIBC() {
        ArrayList<Event> ev = new ArrayList<Event>();
        ev.add(new Event(1,1, new Customer(1)));
        ev.add(new Event(2,2, new Customer(2)));
        ev.add(new Event(3, 1, new Customer(3)));
        
        //Out of bounds index
        int theAns = ev.get(8).getType();
        int trueAns = 1;
        
        assertEquals(theAns, trueAns);
    }
    
    /**
     * Tests the normal boundary condition for the setTime() method of the Event class
     */
    @Test
    public void TestSetTimeNC1() {
        Event e = new Event(4, 2, new Customer(4));
        
        e.setTime(50, 3);
        int theAns = e.getTime();
        int trueAns = 53;
        
        assertEquals(theAns, trueAns);
    }
    
    /**
     * Tests the normal boundary condition for the setTime() method of the Event class
     */
    @Test
    public void TestSetTimeNC2() {
        Event e = new Event(400, 2, new Customer(400));
        
        e.setTime(0, 1);
        int theAns = e.getTime();
        int trueAns = 1;
        
        assertEquals(theAns, trueAns);
    }
    
    /**
     * Tests the boundary condition for the setTime() method of the Event class
     */
    @Test
    public void TestSetTimeBC1() {
        Event e = new Event(0, 2, new Customer(0));
        
        e.setTime(100, 100);
        int theAns = e.getTime();
        int trueAns = 200;
        
        assertEquals(theAns, trueAns);
    }
    
    /**
     * Tests the boundary condition for the setTime() method of the Event class
     */
    @Test
    public void TestSetTimeBC2() {
        Event e = new Event(20, 2, new Customer(20));
        
        e.setTime(0, 0);
        int theAns = e.getTime();
        int trueAns = 0;
        
        assertEquals(theAns, trueAns);
    }
    
    /**
     * Tests the invalid boundary condition for the setTime() method of the Event class
     */
    public void TestSetTimeIBC() {
        Event e = new Event(4, 2, new Customer(4));
        
        //Invalid data types
        //e.setTime('h', 'f');
        int theAns = e.getTime();
        int trueAns = 2;
        
        assertEquals(theAns, trueAns);
    }
    
    /**
     * Tests the normal boundary condition for the setType() method of the Event class
     */
    @Test
    public void TestSetTypeNC1() {
        Event e = new Event(0, 2, new Customer(0));
        
        e.setType(1);
        int theAns = e.getType();
        int trueAns = 1;
        
        assertEquals(theAns, trueAns);
    }
    
    /**
     * Tests the normal boundary condition for the setType() method of the Event class
     */
    @Test
    public void TestSetTypeNC2() {
        Event e = new Event(30, 1, new Customer(30));
        
        e.setType(2);
        int theAns = e.getType();
        int trueAns = 2;
        
        assertEquals(theAns, trueAns);
    }
    
    /**
     * Tests the boundary condition for the setType() method of the Event class
     */
    @Test
    public void TestSetTypeBC1() {
        Event e = new Event(10, 2, new Customer(10));
        
        e.setType(1);
        int theAns = e.getType();
        int trueAns = 1;
        
        assertEquals(theAns, trueAns);
    }
    
    /**
     * Tests the boundary condition for the setType() method of the Event class
     */
    @Test
    public void TestSetTypeBC2() {
        Event e = new Event(100, 1, new Customer(100));
        
        e.setType(2);
        int theAns = e.getType();
        int trueAns = 2;
        
        assertEquals(theAns, trueAns);
    }
    
    /**
     * Tests the invalid boundary condition for the setType() method of the Event class
     */
    public void TestSetTypeIBC() {
        Event e = new Event(0, 2, new Customer(0));
        
        //Invalid data type
        //e.setType("y");
        int theAns = e.getType();
        int trueAns = 1;
        
        assertEquals(theAns, trueAns);
    }
    
    /**
     * Tests the normal boundary condition for the compareTo() method of the Event class
     */
    @Test
    public void TestCompareToNC1() {
        Event e1 = new Event(0, 1, new Customer(0));
        Event e2 = new Event(2, 2, new Customer(2));
        
        int theAns = e1.compareTo(e2);
        int trueAns = -2;
        
        assertEquals(theAns, trueAns);
    }
    
    /**
     * Tests the normal boundary condition for the compareTo() method of the Event class
     */
    @Test
    public void TestCompareToNC2() {
        Event e1 = new Event(30, 1, new Customer(30));
        Event e2 = new Event(11, 2, new Customer(11));
        
        int theAns = e1.compareTo(e2);
        int trueAns = 19;
        
        assertEquals(theAns, trueAns);
    }
    
    /**
     * Tests the boundary condition for the compareTo() method of the Event class
     */
    @Test
    public void TestCompareToBC1() {
        Event e1 = new Event(100, 1, new Customer(100));
        Event e2 = new Event(0, 2, new Customer(0));
        
        int theAns = e1.compareTo(e2);
        int trueAns = 100;
        
        assertEquals(theAns, trueAns);
    }
    
    /**
     * Tests the boundary condition for the compareTo() method of the Event class
     */
    @Test
    public void TestCompareToBC2() {
        Event e1 = new Event(5, 1, new Customer(5));
        Event e2 = new Event(6, 1, new Customer(6));
        
        int theAns = e1.compareTo(e2);
        int trueAns = -1;
        
        assertEquals(theAns, trueAns);
    }
    
    /**
     * Tests the invalid boundary condition for the compareTo() method of the Event class
     */
    public void TestCompareToIBC() {
        Event e1 = new Event(0, 1, new Customer(0));
        
        //Invalid data type
        //Event e2 = new Event("H", 2, new Customer(2));
        
        //int theAns = e1.compareTo(e2);
        int trueAns = -2;
        
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
