/**
 * This class defines the different possible events in the simulation
 * @Richard Phan
 * @March 15, 2019
 */
public class Event implements Comparable<Event>{
    //Data field for the type of event: 1 is arrive and 2 is departure
    private int type; 
    //Time of arrival
    private int tArrive;
    //Which customer the event is referring to
    private Customer c;
    /**
     * Constructor for objects of type Event
     */
    public Event() {
        //Blank constructor refers to the other constructor
        this(0, 1, null);
    }
    
    /**
     * Constructor for objects of type Event
     */
    public Event(int _tArrive, int _type, Customer _c) {
        //Second constructor initializes the instance variables
        tArrive = _tArrive;
        type = _type;
        c = _c;
    }
    
    /**
     * Returns the object Customer that is associated with the event
     * @return The Customer
     */
    public Customer getCustomer() {
        //Method returns customer the event is referring to
        return c;
    }
    
    /**
     * Changes the customer associated with the event to the one in parameter
     * @param h An instance of the Customer class that we want associated to the event
     */
    public void setCustomer(Customer h) {
        //Changes the customer the event is referring to
        c = h;
    }
    
    /**
     * Returns the time the event occurs
     * @return Time
     */
    public int getTime() {
        //Returns the arrival time of the customer
        return tArrive;
    }
    
    /**
     * Returns the type of event
     * @return Type
     */
    public int getType() {
        //Returns which kind of event we are looking at
        return type;
    }
    
    /**
     * Changes the time of the event
     * @param t The first time
     * @param t1 The second time
     */
    public void setTime(int t, int t1) {
        //Changes the time of the event
        tArrive = t1 + t;
    }
    
    /**
     * Changes the type of the event
     * @param i The type of event that we want to change to
     */
    public void setType(int i) {
        //Changes the event type
        type = i;
    }
    
    /**
     * Compares the times of two events so that PriorityQueue can know what to prioritize
     * @param e An event that we want to compare the current one to
     * @return Whether the time is less than, greater than, or equal to each other
     */
    public int compareTo(Event e) {
        //Does the comparing of all events based on time so we can use in
        //PriorityQueue
        return tArrive - e.tArrive;
    }
}
