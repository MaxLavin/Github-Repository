import sofia.micro.*;

// -------------------------------------------------------------------------
/**
 *  this is the test for the wall ant, a pure defensive ant
 *
 *  @author max24
 *  @version 2014.11.7
 */
public class WallAntTest extends TestCase
{
    //~ Fields ................................................................
    /**
     * The colony field
     */
    Colony home;
    /**
     * The wallant field
     */
    WallAnt ant;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new WallAntTest test object.
     */
    public WallAntTest()
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
        ant = new WallAnt();
        home.add(ant, 3, 3);
    }


    // ----------------------------------------------------------
    /**
     * This tests the act when the health of the ant
     * isn't 0
     */
    public void testActA()
    {
        ant.act();
        
        assertEquals(home.getObjects(WallAnt.class).size(), 1);
        assertEquals(ant.getGridX(), 3);
        assertEquals(ant.getGridY(), 3);
    }
    /**
     * This tests when the health is 0
     */
    public void testActB()
    {
        ant.injure(4);
        ant.act();
        
        assertEquals(home.getObjects(WallAnt.class).size(), 0);
    }
}
