import sofia.micro.*;

//-------------------------------------------------------------------------
/**
 *  This is the hungry ant actor.
 *  it begins with 1 health and costs 5 units
 *  it tkes 240 turns to digest bees
 *
 *  @author max24
 *  @version 2014.11.2
 */
public class HungryAnt extends Ant
{
    //~ Fields ................................................................
    /**
     * Bee field
     */
    Bee sting;
    /**
     * Int for loop
     */
    int i = 0;
    



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new HungryAnt object.
     */
    public HungryAnt()
    {
        health = 1;
        cost = 5;
    }


    //~ Methods ...............................................................
    /**
     * This is the eating method, 
     */
    public void eat()
    {
        if (this.getOneIntersectingObject(Bee.class) != null)
        {
            sting = this.getOneIntersectingObject(Bee.class);
            sting.remove();
        }
    }
    /**
     * This is the act method
     */
    public void act()
    {
        if (i <= 0 && 
            this.getOneIntersectingObject(Bee.class) != null)
        {
            this.eat();
            i = 240;
        }
        else
        {
            i = i - 1;
        }
        if (health == 0)
        {
            
            this.remove();
        }
    }
        
            
        


}
