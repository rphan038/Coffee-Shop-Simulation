import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.*;
/**
 * This class runs the actual simulation using instances of the other classes
 * 
 * @Richard Phan
 * @March 15, 2019
 */
public class CoffeeShopSim {
    //Amount of money made per customer
    private float p;
    //Amount of money per day a cashier makes
    private float c;
    //Average amount of time a cashier spends serving a customer
    private int t;
    //Counts how many cashiers there are
    private int counter;
    //Keeps track of the total profit made by the customers
    private float profit;
    //The "line" that customers will wait in
    private Queue<Customer> q = new ArrayDeque<Customer>();
    //ArrayList full of all the arrival times of the customers
    private ArrayList<Integer> arrival = new ArrayList<Integer>();
    //ArrayList that contains the amount of time that each customer waits
    private ArrayList<Integer> wait = new ArrayList<Integer>();
    //ArrayList of customers
    private ArrayList<Customer> customers = new ArrayList<Customer>();
    //PriorityQueue of events, both arrival and departure
    private PriorityQueue<Event> eventQ = new PriorityQueue<Event>();
    /**
     * Constructor for objects of class CoffeeShopSim
     */
    public CoffeeShopSim() {
        //Initializes some of the instance variables
        profit = 0;
        int time = 0;
        int count = 0;
        counter = 0;
        //Instance of the scanner class to read the file
        Scanner sc = null;
        //Try catch block
        try{
            //Initializes the scanner
            sc = new Scanner(new FileReader("input.txt"));
            //While ther is a next line....
            while(sc.hasNextLine()) {
                if(count == 0) {
                    //The first line is the p value
                    p = Float.parseFloat(sc.next());
                    count++;
                } else if(count == 1) {
                    //The second line is the c value
                    c = Float.parseFloat(sc.next());
                    count++;
                } else if(count == 2) {
                    //The third line is the t value
                    t = Integer.parseInt(sc.next());
                    count++;
                } else {
                    //The rest of the lines will be worked on here
                    //Puts a whole line into a string
                    String line = sc.next();
                    //Declares and initializes another scanner to read each word
                    Scanner str = new Scanner(line);
                    //While there is a next word...
                    while(str.hasNextLine()) {
                        //Reads each word
                        String w = str.next();
                        if((!w.equals("PM") && !w.equals("AM"))) {
                            //Converts each string to a character array
                            char[] nums = w.toCharArray();
                            //Calculates the time of arrival
                            time = (10*(nums[0] - 48) + (nums[1] - 48)) - 6; 
                            time = (time*3600) + (10*(nums[3] - 48) + (nums[4] - 48))*60; 
                            time = time + 10*(nums[6] - 48) + (nums[7] - 48);
                            //Adds the time to the ArrayList
                            arrival.add(time);
                            //Increments the counter
                            counter++;
                        }
                    }
                }
            }
        } catch (Exception e) {
            //Prints error if there is an error
            System.out.println("Error");
        }
    }
    
    /**
     * Main method that will create an instance of this class to run the simulation
     * @param args Command Line Argument input
     */
    public static void main(String[] args) {
        CoffeeShopSim CSS = new CoffeeShopSim();
        CSS.run(args);
    }

    /**
     * This method runs the actual simulation
     * @param a An array of Strings
     */
    public void run(String[] a) {
        //The number of cashiers is determined through command line arguments
        int s = Integer.parseInt(a[0]);
        //Initializes the cashier variable
        int availCashiers = 0;
        //Initializes the customer ArrayList
        customerInitializer();
        //Adds all of the arrival events into the PriorityQueue
        addToPriorityQ(s);
        //Creates an instance of the event class to use in the simulation
        Event event = null;
        //Initializes overflow variable keeps track how many people overflow
        int overFlow = 0;
        //According to how many cashiers there are, it initializes the number
        //of people who start off at the cashier. Determines how many cashiers
        //there are
        initialDepartEvents(s);
        //Where there are still events....
        while(!eventQ.isEmpty()) {
            //event equals the most recent event
            event = eventQ.poll();
            //If that event is an arrival, Arrival is represented by 1
            if(event.getType() == 1) {
                //Add a customer to the Queue if the queue is not longer than
                //8*s
                if(q.size() < 8*s) {
                    q.add(event.getCustomer());
                } else {
                    //Otherwise the customer won't be added and will increase
                    //the overflow counter
                    overFlow++;
                }
                //If that event is a departure...
            } else if(event.getType() == 2) {
                //Amount of cashiers increases by 1
                availCashiers++;
                //Increase the amount of profit made
                profit = profit + p;
            }
            //This if statement puts departure events back into the priorityQ
            if(q.size() > 0 && availCashiers > 0) {
                //Instance of the customer class is initialzed as the first
                //or head element of the Queue of customers
                Customer c = q.element();
                //Removes that head element
                q.remove();
                //Sets the data field of customer in event to c
                event.setCustomer(c);
                //Changes the event type to departure (2)
                event.setType(2);
                //Sets the time when they will be departing
                event.setTime(event.getTime(), t);
                //Adds the event back into PriorityQueue
                eventQ.add(event);
                //Decreases the number of cashiers
                availCashiers--;
                //Adds Customer c's wait time into the ArrayList
                wait.add(event.getTime() - c.getArriveT() - 120);
            }
        }
        //Determines overflow rate
        float overRate = (float) overFlow/(counter);
        //Prints the values we are testing for
        System.out.println("Total Profit: $" + profit + "0");
        System.out.println("Total Cost: $" + s*c + "0");
        System.out.println("Net Profit: $" + (profit - s*c) + "0");
        System.out.println("Average Wait Time: " + avgWait(wait) + " seconds");
        System.out.println("Max Wait Time: " + findMaxWait(wait) + " seconds");
        System.out.println("Overflow Rate: " + (overRate*100) + "%");
    }
    
    /**
     * Initializes the first departure events according to the number of cashiers
     * @param num An integer that represents the number of cashiers
     */
    //Unable to unit test this method - results in an error
    public void initialDepartEvents(int num) {
        //Initialzes the first departure events according to how many cashiers
        //there are because if there are 2 cashiers, the first two who arrive
        //don't have to wait in the queue
        for(int i = 0; i < num; i++) {
            eventQ.add(new Event(arrival.get(i) + t, 2, customers.get(i)));
        }
    }
    
    /**
     * Initializes the Customers ArrayList with the correct arrival times
     */
    public void customerInitializer() {
        //Initializes the ArrayList full of the Customers class and assigns each
        //element an arrival time
        for(int i = 0; i < counter; i++) {
            customers.add(new Customer(arrival.get(i)));
        }
    }
    
    /**
     * Adds all of the arrival events into the PriorityQueue
     * @param s An integer which represents how many customers have already been served and didn't have to wait in the queue
     */
    //Unable to unit test this method - results in an error
    public void addToPriorityQ(int s) {
        //Adds all of the arrival events into the priority queue except for the
        //customers who didn't have to wait in the queue
        for(int j = s; j < counter; j++) {
            eventQ.add(new Event(arrival.get(j), 1, customers.get(j)));
        }
    }
    
    /**
     * Finds the maximum wait time
     * @param n ArrayList of type Integer that contains all of customers' wait times
     * @return The maximum wait time
     */
    public int findMaxWait(ArrayList<Integer> n) {
        //Finds the longest time a customer had to wait in line
        int max = 0;
        for(int i = 0; i < n.size(); i++) {
            if(n.get(i) > max) {
                max = n.get(i);
            }
        }
        return max;
    }
    
    /**
     * Finds the average wait time a customer experiences in the queue
     * @param m ArrayList of type Integer that contains all of the customers' wait times
     * @return The average wait time
     */
    public int avgWait(ArrayList<Integer> m) {
        //Finds the average amount of time a customer had to wait in line
        int total = 0;
        for(int i = 0; i < m.size(); i++) {
            total = total + m.get(i);
        }
        return total/m.size();
    }
}
