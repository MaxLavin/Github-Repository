import sofia.micro.*;

//-------------------------------------------------------------------------
/**
 *  The bee actor, the main enemy.
 *  starts with 3 health.
 *
 *  @author max24
 *  @version 2014.11.2
 */
public class Bee extends Actor
{
    //~ Fields ................................................................
    /**
     * This is the bees health
     */
    int health;
    /**
     * This is a counter for the turns
     */
    int i = 0;
    /**
     * Ant class field
     */
    Ant prey;
    



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Bee object.
     */
    public Bee()
    {
        this.turn(180);
        health = 3;
    }


    //~ Methods ...............................................................
    /**
     * This is the injure method
     * it counts the damage taken by the bee
     * @param n   the amount injured
     */
    public void injure(int n)
    {
        health = health - n;
    }
    /**
     * This is the get health method
     * which returns the health of the bee
     * @return   the health of the bee
     */
    public int getHealth()
    {
        return health;
    }
    /**
     * used when being attacking
     * @param ant   the ant being attacked
     */
    public void attack(Ant ant)
    {
        if (i != 40)
        {
            i++;
        }
        if (i == 40)
        {
            ant.injure(1);
            i = 0;
        }
    }
    /**
     * This is the act method
     */
    public void act()
    {
        this.move(.0125);
        if (this.getOneIntersectingObject(Ant.class) != null)
        {
            prey = this.getOneIntersectingObject(Ant.class);
            this.attack(prey);
            this.move(0);
        }
        if (health == 0)
        {
            this.remove();
        }
    }
        
    

}
