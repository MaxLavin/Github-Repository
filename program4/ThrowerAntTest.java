import sofia.micro.*;

// -------------------------------------------------------------------------
/**
 *  This is the test for the thrower ant
 *
 *  @author max24
 *  @version 2014.11.7
 */
public class ThrowerAntTest extends TestCase
{
    //~ Fields ................................................................
    /**
     * This is the leaf field used to test the thrower
     * method
     */

    Leaf star;
    /**
     * This is the colony field
     */
    Colony home;
    /**
     * The thrower ant
     */
    ThrowerAnt ant;
    


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new ThrowerAntTest test object.
     */
    public ThrowerAntTest()
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
        home = new Colony();
        ant = new ThrowerAnt();
        home.add(ant, 3, 3);
    }


    // ----------------------------------------------------------
    /**
     * This is the test for the leaf thrower method
     */
    public void testThrower()
    {
        ant.thrower();
        star = ant.getOneIntersectingObject(Leaf.class);
        assertEquals(home.getObjects(Leaf.class).size(), 1);
        assertEquals(star.getGridX(), 3);
        assertEquals(star.getGridY(), 3);
    }
    /**
     * This tests the Act method.
     * when the health of the ant isn't 0
     * and the turn is allowed to run to 120
     */
    public void testActA()
    {
        this.run(home, 120);
        star = ant.getOneIntersectingObject(Leaf.class);
        
        assertEquals(home.getObjects(Leaf.class).size(), 1);
        assertEquals(star.getGridX(), 3);
        assertEquals(star.getGridY(), 3);
        
        assertEquals(ant.getGridX(), 3);
        assertEquals(ant.getGridY(), 3);
        assertEquals(home.getObjects(ThrowerAnt.class).size(), 
                     1);
    }
    /**
     * This tests when the health isn't 0
     * and the turn isnt allowed to run to 120
     */
    public void testActB()
    {
        this.run(home, 30);
        
        assertEquals(home.getObjects(Leaf.class).size(), 0);
        
        assertEquals(ant.getGridX(), 3);
        assertEquals(ant.getGridY(), 3);
        assertEquals(home.getObjects(ThrowerAnt.class).size(), 
                     1);
    }
    /**
     * This is the test for when the health is 0
     */
    public void testActC()
    {
        ant.injure(1);
        ant.act();
        
        assertEquals(home.getObjects(ThrowerAnt.class).size(), 
                     0);
    }
        

}
