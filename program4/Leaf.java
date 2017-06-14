import sofia.micro.*;

//-------------------------------------------------------------------------
/**
 *  This is the leaf actor, it moves across the row
 *  at a pace of .025 a grid per turn.
 *  it deals 1 damage to bees, and disapears when it
 *  hits the bee or reaches the end
 *
 *  @author max24
 *  @version 2014.11.2
 */
public class Leaf extends Actor
{
    //~ Fields ................................................................


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Leaf object.
     */
    public Leaf()
    {
        /*# Do any work to initialize your class here. */
    }


    //~ Methods ...............................................................
    /**
     * This is the attacking method
     */
    public void attack()
    {
        boolean hit;
        
        if (this.getOneIntersectingObject(Bee.class) != null)
        {
            Bee sting = this.getOneIntersectingObject(Bee.class);
            sting.injure(1);
            hit = true;
            
        }
        else
        {
            hit = false;
        }
        if (hit || this.getGridX() == 9)
        {
            this.remove();
        }
    }
    /**
     * The act Method
     */
    public void act()
    {
        this.move(.025);
        this.attack();
            
    }


}
