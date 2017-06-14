import sofia.micro.*;

//-------------------------------------------------------------------------
/**
 *  This is the harvester ant.
 *  it starts with 1 health, a cost of 2 units, and it collects one 
 *  food unit per 40 turns
 *
 *  @author max24
 *  @version 2014.11.2
 */
public class HarvesterAnt extends Ant
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new HarvesterAnt object.
     */
    public HarvesterAnt()
    {
        health = 1;
        cost = 2;
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
