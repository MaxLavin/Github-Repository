import sofia.micro.*;

// -------------------------------------------------------------------------
/**
 *  This tests the Bee actor
 *
 *  @author max24
 *  @version 2014.11.7
 */
public class BeeTest extends TestCase
{
    //~ Fields ................................................................
    /**
     * ths is the colony field
     */
    Colony home;
    /**
     * This is the bee field
     */
    Bee bee;
    /**
     * This is the ant field
     */
    Ant ant;
    


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new BeeTest test object.
     */
    public BeeTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        bee = new Bee();
        home = new Colony();
        ant = new Ant();
        home.add(bee, 3, 3);
        home.add(ant, 3, 3);
    }


    // ----------------------------------------------------------
    /**
     * This tests the get health method for the bee
     */
    public void testGetHealth()
    {
        ant.remove();
        
        assertEquals(bee.getHealth(), 3);
    }
    /**
     * This tests the injure method
     */
    public void testInjure()
    {
        ant.remove();
        bee.injure(1);
        
        assertEquals(bee.getHealth(), 2);
    }
    /**
     * this tests the attack method when the turn isnt 
     * allowed to run to 40
     */
    public void testAttackA()
    {
        bee.attack(ant);
        
        assertEquals(ant.getHealth(), 0);
    }
    /**
     * This tests the attack method when the turn
     * is allowed to go to 40
     */
    public void testAttackB()
    {
        this.run(home, 40);
        bee.attack(ant);
        
        assertEquals(ant.getHealth(), -1);
    }
    /**
     * This tests the act when the turn isnt allowed 
     * to run to 40 and the ant is present
     */
    public void testActA()
    {
        this.run(home, 20);
        
        assertEquals(ant.getHealth(), 0);
        assertEquals(bee.getGridX(), 3);
        assertEquals(bee.getGridY(), 3);
        assertEquals(
            home.getObjects(Bee.class).size(), 1);
    }
    /**
     * This tests the act method when the ant is
     * present and the time is allowed to run to 40
     */
    public void testActB()
    {
        this.run(home, 40);
        
        assertEquals(ant.getHealth(), -1);
        assertEquals(bee.getGridX(), 3);
        assertEquals(bee.getGridY(), 3);
        assertEquals(
            home.getObjects(Bee.class).size(), 1);
    }
    /**
     * This tests the act when no ant is present
     */
    public void testActC()
    {
        ant.remove();
        bee.act();
        
        assertEquals(bee.getGridX(), 3);
        assertEquals(bee.getGridY(), 3);
        assertEquals(
            home.getObjects(Bee.class).size(), 1);
    }
    /**
     * This tests the act when the bees health is 0
     */
    public void testActD()
    {
        ant.remove();
        bee.injure(3);
        bee.act();
        
        assertEquals(
            home.getObjects(Bee.class).size(), 0);
    }
        
        
        
    
        

}
