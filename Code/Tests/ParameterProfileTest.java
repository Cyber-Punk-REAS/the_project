package Tests;



import org.junit.*;

import Design_Model.ParameterProfile;

public class ParameterProfileTest {
	ParameterProfile p;
	@Before
    public void init() {
    	p = new ParameterProfile(0,0,0,1,0);
    }
	@After
    public void finish() {
    	p = null;
    }
	/**
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
    
}
