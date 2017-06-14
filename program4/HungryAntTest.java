import sofia.micro.*;

// -------------------------------------------------------------------------
/**
 *  This is the test for the HungryAnt, which is an offensive ant
 *
 *  @author max24
 *  @version 2014.11.7
 */
public class HungryAntTest extends TestCase
{
    //~ Fields ................................................................
    /**
     * This is the colony field
     */
    Colony home;
    /**
     * This is the ant field
     */
    HungryAnt ant;
    /**
     * This is the bee field
     */
    Bee bee;
    


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new HungryAntTest test object.
     */
    public HungryAntTest()
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
        ant = new HungryAnt();
        bee = new Bee();
        home.add(ant, 3, 3);
        home.add(bee, 3, 3);
    }


    // ----------------------------------------------------------
    /**
     * This eat method, which removes the bee
     * this case is when there is a bee on the ant
     */
    public void testEatA()
    {
        ant.eat();
        
        assertEquals(home.getObjects(Bee.class).size(), 0);
        assertEquals(home.getObjects(HungryAnt.class).size(), 
                     1);
        assertEquals(ant.getGridY(), 3);
        assertEquals(ant.getGridX(), 3);
    }
    /**
     * This tests the eat method when 
     * the bee isnt on the ant
     */
    public void testEatB()
    {
        bee.setGridLocation(4, 4);
        ant.eat();
        
        assertEquals(home.getObjects(Bee.class).size(), 1);
        assertEquals(bee.getGridX(), 4);
        assertEquals(bee.getGridY(), 4);
        assertEquals(home.getObjects(HungryAnt.class).size(), 
                     1);
        assertEquals(ant.getGridY(), 3);
        assertEquals(ant.getGridX(), 3);
    }
    /**
     * This tests the act method when the ant
     * is empty(its been >120 turns) and the bee is on the ant
     */
    public void testActA()
    {
        this.run(home, 1);
        
        assertEquals(home.getObjects(Bee.class).size(), 0);
        assertEquals(home.getObjects(HungryAnt.class).size(), 
                     1);
        assertEquals(ant.getGridY(), 3);
        assertEquals(ant.getGridX(), 3);
    }
    /**
     * this tests the act when the ant is empty
     * and the bee isnt on the ant
     */
    public void testActB()
    {
        bee.setGridLocation(4, 4);
        ant.act();
        
        assertEquals(home.getObjects(Bee.class).size(), 1);
        assertEquals(bee.getGridX(), 4);
        assertEquals(bee.getGridY(), 4);
        assertEquals(home.getObjects(HungryAnt.class).size(), 
                     1);
        assertEquals(ant.getGridY(), 3);
        assertEquals(ant.getGridX(), 3);
    }
    /**
     * This tests the act method when the ant is full
     * (it hasnt been 240 turns since the ant ate)
     * and the bee is one the ant 
     */
    public void testActC()
    {
        bee.setGridLocation(4, 4);
        home.add(new Bee(), 3, 3);
        ant.act();
        bee.setGridLocation(3, 3);
        ant.act();
        
        assertEquals(home.getObjects(Bee.class).size(), 1);
        assertEquals(bee.getGridX(), 3);
        assertEquals(bee.getGridY(), 3);
        assertEquals(home.getObjects(HungryAnt.class).size(), 
                     1);
        assertEquals(ant.getGridY(), 3);
        assertEquals(ant.getGridX(), 3);
    }
    /**
     * This tests the act method when the ant is full and
     * the bee isnt on the ant
     */
    public void textActD()
    {
        bee.setGridLocation(4, 4);
        home.add(new Bee(), 3, 3);
        ant.act();
        ant.act();
        
        assertEquals(home.getObjects(Bee.class).size(), 1);
        assertEquals(bee.getGridX(), 4);
        assertEquals(bee.getGridY(), 4);
        assertEquals(home.getObjects(HungryAnt.class).size(), 
                     1);
        assertEquals(ant.getGridY(), 3);
        assertEquals(ant.getGridX(), 3);
    }
    /**
     * This tests the act when the ant has 0 health
     */
    public void testActE()
    {
        bee.remove();
        ant.injure(1);
        ant.act();
        
        assertEquals(home.getObjects(HungryAnt.class).size(), 
                     0);
    }
        
        
        
    

}
