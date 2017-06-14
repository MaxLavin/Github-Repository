import sofia.micro.*;

//-------------------------------------------------------------------------
/**
 *  This is the wall defence ant.
 *  it starts with 4 health and costs 4 units
 *
 *  @author max24)
 *  @version 2014.11.8
 */
public class WallAnt extends Ant
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new WallAnt object.
     */
    public WallAnt()
    {
        health = 4;
        cost = 4;
    }


    //~ Methods ...............................................................
    /**
     * This is the act method
     */
    public void act()
    {
        if (health == 0)
        {
            this.remove();
        }
    }


}
