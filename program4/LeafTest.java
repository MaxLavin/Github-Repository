import sofia.micro.*;

// -------------------------------------------------------------------------
/**
 *  This is a test for the leaf, the ammo of the thrower class
 *
 *  @author max24
 *  @version 2014.11.7
 */
public class LeafTest extends TestCase
{
    //~ Fields ................................................................
    /**
     * This is the colony field
     */
    Colony home;
    /**
     * This is the leaf field
     */
    Leaf star;
    /**
     * This is the bee field
     */
    Bee bee;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new LeafTest test object.
     */
    public LeafTest()
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
        star = new Leaf();
        bee = new Bee();
        home.add(star, 3, 3);
        home.add(bee, 3, 3);
    }


    // ----------------------------------------------------------
    /**
     * This tests the attack method when the leaf is 
     * intersecing the bee (bee health sould decrease by 1)
     */
    public void testAttackA()
    {
        star.attack();
        
        assertEquals(home.getObjects(Bee.class).size(), 1);
        assertEquals(bee.getHealth(), 2);
        assertEquals(bee.getGridX(), 3);
        assertEquals(bee.getGridY(), 3);
        
        assertEquals(home.getObjects(Leaf.class).size(), 0);
    }
    /**
     * this tests the attack method when there is no
     * bee intersecting the leaf
     * and the leaf isnt at the end of the line.
     */
    public void testAttackBee()  // attackBee...get it?
    {
        bee.setGridLocation(4, 4);
        star.attack();
        
        assertEquals(home.getObjects(Bee.class).size(), 1);
        assertEquals(bee.getHealth(), 3);
        assertEquals(bee.getGridX(), 4);
        assertEquals(bee.getGridY(), 4);
        
        assertEquals(home.getObjects(Leaf.class).size(), 1);
        assertEquals(star.getGridX(), 3);
        assertEquals(star.getGridY(), 3);
    }
    /**
     * This tests the attack method when the
     * leaf is at the end of the line
     */
    public void testAttackC()
    {
        bee.remove();
        star.setGridLocation(9, 3);
        star.attack();
        
        assertEquals(home.getObjects(Leaf.class).size(), 0);
    }
    /**
     * This tests the act under the same conditions
     * as attackA
     */
    public void testActA()
    {
        star.act();
        
        assertEquals(home.getObjects(Bee.class).size(), 1);
        assertEquals(bee.getHealth(), 2);
        assertEquals(bee.getGridX(), 3);
        assertEquals(bee.getGridY(), 3);
        
        assertEquals(home.getObjects(Leaf.class).size(), 0);
    }
    /**
     * This tests the act under the same conditions as
     * attackBee
     */
    public void testActB()
    {
        bee.setGridLocation(4, 4);
        star.act();
        
        assertEquals(home.getObjects(Bee.class).size(), 1);
        assertEquals(bee.getHealth(), 3);
        assertEquals(bee.getGridX(), 4);
        assertEquals(bee.getGridY(), 4);
        
        assertEquals(home.getObjects(Leaf.class).size(), 1);
        assertEquals(star.getGridX(), 3);
        assertEquals(star.getGridY(), 3);
    }
    /**
     * This tests the act method
     * in the same conditions as attackC
     */
    public void testActC()
    {
        bee.remove();
        star.setGridLocation(9, 3);
        star.act();
        
        assertEquals(home.getObjects(Leaf.class).size(), 0);
    }

}
