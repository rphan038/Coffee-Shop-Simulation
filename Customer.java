/**
 * This class defines the details that a Customer would have
 * @Richard Phan
 * @March 15, 2019
 */
public class Customer {
    //Arrival time of the customer
    private int tArrive;
    //The serving time of the customer
    /**
     * Constructor for objects of type Customer
     */
    public Customer(int _tArrive) {
        //Constructor initializes the instance variables
        tArrive = _tArrive;
    }
    
    /**
     * Returns the arrival time of the customer
     * @return The arrival time
     */
    public int getArriveT() {
        //Returns the arrival time of the customer
        return tArrive;
    }
}
