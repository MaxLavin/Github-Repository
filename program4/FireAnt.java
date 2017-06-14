import sofia.micro.*;
import java.util.List;



//-------------------------------------------------------------------------
/**
 *  This is the fire ant actor.
 *  it begins with 1 health, cost 4 untis, and deals 3 damage when it dies
 *
 *  @author max24
 *  @version 2014.11.2
 */
public class FireAnt extends Ant
{
    //~ Fields ................................................................
    


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new FireAnt object.
     */
    public FireAnt()
    {
        health = 1;
        cost = 4;
    }


    //~ Methods ...............................................................
    /**
     * This is the act method
     */
    public void act()
    {
        List<Bee> range = this.getObjectsInRange(1, Bee.class);
        int x = range.size();

        if (x != 0)
        {
            if (health == 0)
            {
                for (int i = 0; i < x; i++)
                {
                    range.get(i).injure(3);
                }
                this.remove();
            }
        }
        else
        {
            if (health == 0)
            {
                this.remove();
            }
        }
    }
    
    


}
