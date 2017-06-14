import sofia.micro.*;
import sofia.util.Random;

//-------------------------------------------------------------------------
/**
 *  homebase for the bees.
 *  starts with 30 bees, waits 400 turns, then
 *  starts spawning them ever 80-400 turns 
 *  randomly
 *
 *  @author max24
 *  @version 2014.11.6
 */
public class Hive extends Actor
{
    //~ Fields ................................................................
    /**
     * This is the bee counter, which starts at 30
     */
    int bees;
    /**
     * Turn Counter (set at max number of turns)
     */
    int i = 400;



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Hive object.
     */
    public Hive()
    {
        bees = 30;
    }


    //~ Methods ...............................................................
    /**
     * this is the bee counting method
     * it returns the number of bees in the hive.
     * @return returns the # of bees in the hive
     */
    public int getBees()
    {
        return bees;
    }
    /**
     * This changes the number of bees in the hive
     * @param n     number of bees
     */
    public void setBees(int n)
    {
        bees = n;
    }
    /**
     * The main act method, it will create bees
     */
    public void act()
    {
        if (bees > 0)
        {
            if (i == 0)
            {
                int y = Random.generator().nextInt(7);
                y++;
                this.getWorld().add(new Bee(), 9, y);
                bees = bees - 1;
                i = Random.generator().nextInt(321);
                i = i + 80;
            }
            else
            {
                i = i - 1;
            }
        }         
    }
                
    


}
