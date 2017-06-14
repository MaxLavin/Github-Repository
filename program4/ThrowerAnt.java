import sofia.micro.*;

//-------------------------------------------------------------------------
/**
 *  This is the thrower ant actor
 *  it starts with 1 health, costs 4 units
 *  and throws a leaf every 120 turns dealing 1 damage
 *
 *  @author max24
 *  @version 2014.11.2
 */
public class ThrowerAnt extends Ant
{
    //~ Fields ................................................................
    /**
     * This is the leaf field used in the throwing method
     */
    Leaf star;
    /**
     * This is the counter
     */
    int i = 0;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new ThrowerAnt object.
     */
    public ThrowerAnt()
    {
        health = 1;
        cost = 4;
    }


    //~ Methods ...............................................................
    /**
     * This is the attack method, it places a leaf one space ahead of the 
     * ant
     */
    public void thrower()
    {
        star = new Leaf();
        this.getWorld().add(star, this.getGridX(),
                            this.getGridY());    
    }
    /**
     * This is the act method
     */
    public void act()
    {
        
        if (health == 0)
        {
            this.remove();
        }
        i++;
        if (i == 120)
        {
            this.thrower();
            i = 0;
        }
        
            
    }


}
