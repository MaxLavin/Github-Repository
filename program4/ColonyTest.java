import sofia.micro.*;

// -------------------------------------------------------------------------
/**
 *  This is the test For the colony
 *
 *  @author max24
 *  @version 2014.11.8
 */
public class ColonyTest extends TestCase
{
    //~ Fields ................................................................
    /**
     * This is the colony field
     */
    Colony home;
    
    
    


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new ColonyTest test object.
     */
    public ColonyTest()
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
    }


    // ----------------------------------------------------------
    /**
     * This tests the get food method
     * inittaly 10
     */
    public void testGetFood()
    {
        assertEquals(home.getFood(), 10);
    }
    /**
     * This tests the consume food method
     */
    public void testConsumeFood()
    {
        home.consumeFood(1);
        assertEquals(home.getFood(), 9);
    }
    /**
     * This tests the add food method
     */
    public void testAddFood()
    {
        home.addFood(1);
        assertEquals(home.getFood(), 11);
    }
    /**
     * This tests the on touchdown for the Harvester
     * ant
     */
    public void testCreateHarvester()
    {
        home.setSelectedActor(HarvesterAnt.class);
        
        home.onTouchDown(3, 3);
        
        assertEquals(home.getObjects(HarvesterAnt.class).size(), 
                     1);
         
        assertEquals(home.getFood(), 8);
    }
    /**
     * This tests the on touchdown method
     * for throwerant
     */
    public void testCreateThrower()
    {
        home.setSelectedActor(ThrowerAnt.class);
        
        home.onTouchDown(3, 3);
        
        assertEquals(home.getObjects(ThrowerAnt.class).size(),
                     1);
         
        assertEquals(home.getFood(), 6);
    }
    /**
     * This tests the crteation of the fire ant
     */
    public void testCreateFire()
    {
        home.setSelectedActor(FireAnt.class);
        
        home.onTouchDown(3, 3);
        
        assertEquals(home.getObjects(FireAnt.class).size(),
                     1);
         
        
        assertEquals(home.getFood(), 6);
    }
    /**
     * This test the creation of the wall ant
     */
    public void testCreateWall()
    {
        home.setSelectedActor(WallAnt.class);
        
        home.onTouchDown(3, 3);
        
        assertEquals(home.getObjects(WallAnt.class).size(),
                     1);
         
        
        assertEquals(home.getFood(), 6);
    }
    /**
     * This tests the creation of the hungry ant
     */
    public void testCreateHungry()
    {
        home.setSelectedActor(HungryAnt.class);
        
        home.onTouchDown(3, 3);
        
        assertEquals(home.getObjects(HungryAnt.class).size(),
                     1);
         
        
        assertEquals(home.getFood(), 5);
    }
    /**
     * This tests the onTouchdown when the point is out of bounds
     */
    public void testOnTouchdownA()
    {
        home.setSelectedActor(FireAnt.class);
        
        home.onTouchDown(10, 10);
        
        assertEquals(home.getObjects(FireAnt.class).size(),
                     0);
         
        
        assertEquals(home.getFood(), 10);
    }
    /**
     * This tests the onTouchDown when there isnt enough food
     */
    public void testOnTouchDownB()
    {
        home.consumeFood(10);
        home.setSelectedActor(FireAnt.class);
        
        home.onTouchDown(3, 3);
        
        assertEquals(home.getObjects(FireAnt.class).size(), 
                      0);
         
        
        assertEquals(home.getFood(), 0);
    }
    /**
     * This tests the act when there is a bee in the 
     * Queens chamber
     */
    public void testActA()
    {
        home.add(new Bee(), 0, 1);
        home.act();
        assertTrue(home.isGameOver());
        assertFalse(home.isGameWon());
        
    }
    /**
     * This tests the act when there is a
     * harvester ant in on the field and
     * the turn is allowed to go to 40
     */
    public void testActB()
    {
        HarvesterAnt ant = new HarvesterAnt();
        home.add(ant, 3, 3);
        this.run(home, 41);
        
        assertEquals(home.getFood(), 11);
    }
    /**
     * This tests the act when there is a harvester
     * and the turn isnt allowed to run till 40
     */
    public void testActC()
    {
        HarvesterAnt ant = new HarvesterAnt();
        home.add(ant, 3, 3);
        this.run(home, 20);
        
        assertEquals(home.getFood(), 10);
    }
    /**
     * This tests the act when nothing is happeneing
     */
    public void testActD()
    {
        home.act();
        assertEquals(home.getFood(), 10);
    }
        

        
         

}
