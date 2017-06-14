import sofia.micro.*;

// -------------------------------------------------------------------------
/**
 *  this tests the fire ant, which is an offensive ant
 *  there fore bees will be added
 *
 *  @author max24
 *  @version 2014.11.7
 */
public class FireAntTest extends TestCase
{
    //~ Fields ................................................................
    /**
     * This is the colony field
     */
    Colony home;
    /**
     * This is the FireAnt field
     */
    FireAnt ant;
    /**
     * This is the beefield
     */
    Bee bee;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new FireAntTest test object.
     */
    public FireAntTest()
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
        ant = new FireAnt();
        bee = new Bee();
        
        home.add(ant, 3, 3);
        home.add(bee, 3, 3);
    }
    


    // ----------------------------------------------------------
    /**
     * This tests the act when there is a bee and the
     * health doesnt equal 0
     */
    public void testActA()
    {
        ant.act();
        
        assertEquals(home.getObjects(FireAnt.class).size(), 1);
        assertEquals(ant.getGridX(), 3);
        assertEquals(ant.getGridY(), 3);
        
        assertEquals(home.getObjects(Bee.class).size(), 1);
        assertEquals(bee.getGridX(), 3);
        assertEquals(bee.getGridY(), 3);
    }
    /**
     * This tests the act when there is a bee
     * and the ants health is 0
     */
    public void testActB()
    {
        ant.injure(1);
        this.run(home, 1);
        
        assertEquals(home.getObjects(Bee.class).size(), 0);
        assertEquals(home.getObjects(FireAnt.class).size(), 0);
    }
    /**
     * This tests the act when there is no bee (present or in range)
     * and the ant's healht isn't 0
     */
    public void testActC()
    {
        bee.remove();
        
        ant.act();
        assertEquals(home.getObjects(FireAnt.class).size(), 1);
        assertEquals(ant.getGridX(), 3);
        assertEquals(ant.getGridY(), 3);
    }
    /**
     * This tests the act when the bee isnt in the range
     * of the ant and the ants health is 0
     */
    public void testActD()
    {
        bee.setGridLocation(5, 5);
        ant.injure(1);
        ant.act();
        
        assertEquals(home.getObjects(FireAnt.class).size(), 0);
        assertEquals(home.getObjects(Bee.class).size(), 1);
        assertEquals(bee.getGridX(), 5);
        assertEquals(bee.getGridY(), 5);
        
    }
        
        
        
        
        
        

}
