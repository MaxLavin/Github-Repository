import sofia.micro.*;

//-------------------------------------------------------------------------
/**
 *  This is the world
 *
 *  @author max24
 *  @version 2014.11.2
 */
public class Colony extends HomeBase
{
    //~ Fields ................................................................
    /**
     * This is the queens chamber used in the constructor
     */
    QueensChamber goal;
    /**
     * This is the bees hive used in the constructor
     */
    Hive fort;
    /**
     * This is the food counter (cost)
     */
    int food;
    /**
     * This is the turn counter
     */
    int i = 0;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Colony object.
     */
    public Colony()
    {
        super();
        goal = new QueensChamber();
        fort = new Hive();
        food = 10;
        
        this.add(goal, 0, 3);
        this.add(fort, 9, 3);

        // Lay out the ant choices the player can click on in the
        // method call commented out below.  As you add ants, you
        // can add them to this list, so you have a playable
        // version of your game to try out, no matter how much
        // you have left to finish.

        this.setActorChoices(
               HarvesterAnt.class,
               ThrowerAnt.class,
               WallAnt.class,
               FireAnt.class,
               HungryAnt.class);
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Add an ant to the screen when a specific location is clicked.
     * This method is automatically called while the simulation is
     * running, whenever the user clicks on (or taps on) a location
     * in the colony (one that isn't covered by an actor already).
     * 
     * @param x The x-coordinate of the click
     * @param y The y-coordinate of the click
     */
    public void onTouchDown(int x, int y)
    {
        if (x >= 1 && x <= 8 &&
            y >= 1 && y <= 5)
        {
            Ant troop = ((Ant) newActorOfSelectedType());
            if (food - troop.getFoodCost() >= 0)
            {
                this.add(troop, x, y);
                this.consumeFood(troop.getFoodCost());
            }
        }
    }
    /**
     * This is the return food method, used to check the food units
     * @return   the # of food untis
     */
    public int getFood()
    {
        return food;
    }
    /**
     * This is the consume food method
     * it is used to subtract the food units
     * form the colony for every ant created
     * @param n   the amount the food is decreasing
     */
    public void consumeFood(int n)
    {
        food = food - n;
    }
    /**
     * This is the add food method, it goes
     * with the harvesterant and increases the
     * food for the colony
     * @param n   the amount the food is increasing
     */
    public void addFood(int n)
    {
        food = food + n;
    }
    /**
     * This is the act method
     */
    public void act()
    {
        super.act();
        this.getFood();
        if (goal.getOneIntersectingObject(Bee.class) != null)
        {
            this.lose();
        }
        if (fort.getBees() == 0 && 
            this.getObjects(Bee.class).size() == 0)
        {
            this.win();
        }
        if (this.getObjects(HarvesterAnt.class).size() != 0)
        {
            int n = this.getObjects(HarvesterAnt.class).size();
            if (i == 40)
            {
                this.addFood(n);
                i = 0;
            }
            else
            {
                i++;
            }        
        }
    }
}
