import sofia.micro.*;

//-------------------------------------------------------------------------
/**
 *  This is the super class for all ants.
 *  this is for methods that need to be called for all ants
 *  such as the get health method
 *
 *  @author max24
 *  @version 2014.11.2
 */
public class Ant extends Actor
{
    //~ Fields ................................................................
    /**
     * This is the health field for the methods
     */
    int health;
    /**
     * This is the food cost field for the foodcost method
     */
    int cost;
    
    



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Ant object.
     */
    public Ant()
    {
        health = 0;
        cost = 0;
    }


    //~ Methods ...............................................................
    /**
     * This is the method that shows the health of the actor
     * it is used for all ants
     * @return returns the health of the ant
     */
    public int getHealth()
    {
        return health;
    }
    /**
     * This is the damage taking method 
     * @param n        the amount of damage taken
     */
    public void injure(int n)
    {
        health = health - n;
    }
    /**
     * this is the cost checker for the ants
     * @return     the cost of the ant in food
     */
    public int getFoodCost()
    {
        return cost;
    }
    
      
    


}
