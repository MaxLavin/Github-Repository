import sofia.micro.*;

// -------------------------------------------------------------------------
/**
 *  This is the test for the Harvester ant
 *
 *  @author max24
 *  @version 2014.11.7
 */
public class HarvesterAntTest extends TestCase
{
    //~ Fields ................................................................
    /**
     * The colony field
     */
    Colony home;
    /**
     * The harvester ant field
     */
    HarvesterAnt ant;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new HarvesterAntTest test object.
     */
    public HarvesterAntTest()
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
        ant = new HarvesterAnt();
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
        
        assertEquals(home.getObjects(HarvesterAnt.class).size(), 
                     1);
        assertEquals(ant.getGridX(), 3);
        assertEquals(ant.getGridY(), 3);
    }
    /**
     * This tests when the health is 0
     */
    public void testActB()
    {
        ant.injure(1);
        ant.act();
        
        assertEquals(home.getObjects(HarvesterAnt.class).size(), 
                     0);
    }
        

}
