package Tests;



import org.junit.*;

import Design_Model.ParameterProfile;

public class ParameterProfileTest {
	ParameterProfile p;
	@Before
    public void init() {
    	p = new ParameterProfile(0,3,0,1,0);
    }
	@After
    public void finish() {
    	p = null;
    }
	/**
	 * Test Case 1:
	 * This test is aimed at checking that the creation of a ParameterProfile object
	 * is correctly done only if the values given as parameters abide by the rules stated
	 * */
    @Test 
    public void constructorWithInvalidParametersTest(){
    	// Test Case 1.1: Immunity Chance lower than 0;
    	try {
    		 p = new ParameterProfile(-1,0,0,1,0);
    		 Assert.fail("Expected Illegal argument exception (Immunity Chance 1)");
    	}
    	catch (IllegalArgumentException e){
    		Assert.assertNotNull(p);
    		p = null;
    	}
    	// Test Case 1.2: Immunity Chance higher than 100;
    	try {
   		    p = new ParameterProfile(101,0,0,1,0);
   		    Assert.fail("Expected Illegal argument exception (Immunity Chance 2)");
   	    }
   	    catch (IllegalArgumentException e){
   		    Assert.assertNotNull(p);
   		    p = null;
   	    }
    	// Test Case 1.3: Average Friends lower than 0;
    	try {
   		    p = new ParameterProfile(0,-1,0,1,0);
   		    Assert.fail("Expected Illegal argument exception (Average Friends 1)");
   	    }
   	    catch (IllegalArgumentException e){
   		    Assert.assertNotNull(p);
   		    p = null;
   	    }
    	// Test Case 1.4: Average Friends higher than 30;
    	try {
   		    p = new ParameterProfile(0,31,0,1,0);
   		    Assert.fail("Expected Illegal argument exception (Average Friends 2)");
   	    }
   	    catch (IllegalArgumentException e){
   		    Assert.assertNotNull(p);
   		    p = null;
   	    }
    	// Test Case 1.5: Average Days contagious lower than 0;
    	try {
   		    p = new ParameterProfile(0,0,-1,1,0);
   		    Assert.fail("Expected Illegal argument exception (Average Days 1)");
   	    }
   	    catch (IllegalArgumentException e){
   		    Assert.assertNotNull(p);
   		    p = null;
   	    }
    	// Test Case 1.6: Average Days contagious higher than 30;
    	try {
   		    p = new ParameterProfile(0,0,31,1,0);
   		    Assert.fail("Expected Illegal argument exception (Average Days 2)");
   	    }
   	    catch (IllegalArgumentException e){
   		    Assert.assertNotNull(p);
   		    p = null;
   	    }
    	// Test Case 1.7: Days simulation lower or equal to 0;
    	try {
   		    p = new ParameterProfile(0,0,0,0,0);
   		    Assert.fail("Expected Illegal argument exception (Days simulation 1)");
   	    }
   	    catch (IllegalArgumentException e){
   		    Assert.assertNotNull(p);
   		    p = null;
   	    }
    	// Test Case 1.8: Days simulation higher than 60;
    	try {
   		    p = new ParameterProfile(0,0,0,61,0);
   		    Assert.fail("Expected Illegal argument exception (Days simulation 2)");
   	    }
   	    catch (IllegalArgumentException e){
   		    Assert.assertNotNull(p);
   		    p = null;
   	    }
    	// Test Case 1.9: Unemployment chance lower than 0;
    	try {
   		    p = new ParameterProfile(0,0,0,1,-1);
   		    Assert.fail("Expected Illegal argument exception (Unemployment chance 1)");
   	    }
   	    catch (IllegalArgumentException e){
   		    Assert.assertNotNull(p);
   		    p = null;
   	    }
    	// Test Case 1.10: Unemployment chance higher than 100;
    	try {
   		    p = new ParameterProfile(0,0,0,1,101);
   		    Assert.fail("Expected Illegal argument exception (Unemployment chance 2)");
   	    }
   	    catch (IllegalArgumentException e){
   		    Assert.assertNotNull(p);
   		    p = null;
   	    }
    	
    	
    }
    /**
     * Test Case 2:
     * This test checks that, if given a correct ParameterProfile object as a parameter, the function
     * changes the values of the object which the function is being called upon with the values of the given
     * object.
     * */
    @Test
    public void EditTest() {
    	ParameterProfile p2 = new ParameterProfile(1,2,3,4,5);
    	p.editParameters(p2);
    	// Test Case 2.1: Values are changed when calling editParameters
    	Assert.assertEquals("ImmunityChance", 1, p.getStartingImmunityChance());
    	Assert.assertEquals("averageFriends", 2 , p.getAverageFriends(),0);
    	Assert.assertEquals("daysForSimulation", 4, p.getSimulationDays());
    	Assert.assertEquals("unemployment", 5, p.getUnemployment());
    }
    /**
     * Test Case 3:
     * Check that you receive the appropriate values when using getImmunityChance() method
     * */
    @Test
    public void getStartingImmunityChanceTest() {
        Assert.assertEquals("ImmunityChance",0, p.getStartingImmunityChance());
    }
    /**
     * Test Case 4:
     * Check that you receive the appropriate values when using getUnemployment() method
     * */
    @Test
    public void getUnemploymentTest() {
        Assert.assertEquals("unemployment",0, p.getUnemployment());
    }
    /**
     * Test Case 5:
     * Check that you receive the appropriate values when using getFriendsStandardDeviation() method
     * */
    @Test
    public void getFriendsStandardDeviationTest() {
        Assert.assertEquals("StandardDeviation",1,p.getFriendsStandardDeviation(),0);
    }
    /**
     * Test Case 6:
     * Check that you receive the appropriate values when using getAverageFriends() method
     * */
    @Test
    public void getAverageFriendsTest() {
    	Assert.assertEquals("AverageFriends",3,p.getAverageFriends(),0);
    }
    /**
     * Test Case 7:
     * Check that you receive different values when using getDaysContagious() method as it uses a random gaussian every time, and that those values
	 * are atleast bigger than the parameter given to the constructor.
     * */
    @Test
    public void getDaysContagiousTest(){
        Assert.assertNotSame("RandomDaysContagious",p.getDaysContagious(), p.getDaysContagious());
		Assert.assertTrue(p.getDaysContagious() > 0);
    }
    /**
     * Test Case 8:
     * Check that you receive the appropriate values when using getSimulationDays() method
     * */
    @Test
    public void getSimulationDays() {
    	Assert.assertEquals("SimulationDays",1, p.getSimulationDays());
    }
    
}
