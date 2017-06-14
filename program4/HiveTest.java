import sofia.micro.*;


// -------------------------------------------------------------------------
/**
 *  This is the test for the hive method
 *
 *  @author max24
 *  @version 2014.11.8
 */
public class HiveTest extends TestCase
{
    //~ Fields ................................................................
    /**
     * This is the colony field
     */
    Colony home;
    /**
     * This is the hive field
     */
    Hive hive;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new HiveTest test object.
     */
    public HiveTest()
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
        hive = new Hive();
        home.add(hive, 3, 3);
        
    }


    // ----------------------------------------------------------
    /**
     * This tests the getBees method (the default is
     * set to 30)
     */
    public void testGetBees()
    {
        assertEquals(hive.getBees(), 30);
    }
    /**
     * this tests the set bees method
     */
    public void testSetBees()
    {
        hive.setBees(25);
        assertEquals(hive.getBees(), 25);
    }
    /**
     * This tests the act method when
     * the number of bees in the hive is 0
     * 
     */
    public void testActA()
    {
        hive.setBees(0);
        this.run(home, 400);
        hive.act();
        
        assertEquals(home.getObjects(Bee.class).size(), 0);
    }
    /**
     * this tests the act method when bees is greater than 0
     * and the turn isnt allowed to run to 400
     */
    public void testActB()
    {
        hive.setBees(1);
        this.run(home, 20);
        hive.act();
        
        assertEquals(home.getObjects(Bee.class).size(), 0);
    }
    /**
     * This tests the act when the number of bees isnt
     * 0 and the turn is allowed to go to 400
     */
    public void testActC()
    {
        hive.setBees(2);
        this.run(home, 400);
        hive.act();
        
        assertEquals(home.getObjects(Bee.class).size(), 1);
        assertEquals(hive.getBees(), 1);
    }
}
