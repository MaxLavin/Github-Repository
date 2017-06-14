import sofia.micro.*;

// -------------------------------------------------------------------------
/**
 *  This is the test for the Ant Superclass
 *  it tests getHealth(), Injure, and getFoodCost()
 *
 *  @author max24
 *  @version 2014.11.7
 */
public class AntTest extends TestCase
{
    //~ Fields ................................................................
    /**
     * The ant field
     */
    Ant ant;
    /**
     * The colony field
     */
    Colony home;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new AntTest test object.
     */
    public AntTest()
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
        ant = new Ant();
        home.add(ant, 3, 3);
    }


    // ----------------------------------------------------------
    /**
     * This tests the get health method\
     * since it is for the ant superclas
     * it should return 0
     */
    public void testGetHealth()
    {
        assertEquals(ant.getHealth(), 0);
    }
    /**
     * This tests the injure method of the ant
     * it should change the health to
     * -1
     */
    public void testInjure()
    {
        ant.injure(1);
        assertEquals(ant.getHealth(), -1);
    }
    /**
     * This tests the get food cost
     * since it is the ant superclass 
     * it should return 0
     */
    public void testGetFoodCost()
    {
        assertEquals(ant.getFoodCost(), 0);
    }
    
    

}
