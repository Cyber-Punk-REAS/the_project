package testing;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

public class SimulationTest {
	
	Simulation s;
	ParameterProfile parameters;
	Region region;
	Restriction restriction;
	Results results;
	Person person;
	Area area;
	Population population;
	
	
	@Before
	public void init()
	{
		area = mock(Area.class);
		region = mock(Region.class);
		parameters = new ParameterProfile();
		s = new Simulation(parameters, region);
		restriction = new Restriction();
		results = new Results();
		person = population.getRandomPerson();
	}

	@Test
	public void runTest() 
	{	
		//Variables
		int peopleCouldMeetBefore = person.getPeopleCouldMeet();
		
		assertNotNull(s);
		assertNotNull(region);
		assertTrue("The time restriction should be greater than 2", restriction.getTimeRestriction() > 2);
		
		s.run();
		
		assertEquals("The \"Results\" class should return as many days as indicated previously", parameters.getDaysForSimulation(), results.getListDays().size());
		
		if(restriction.getCurfew())
		{
			assertEquals(person.getPeopleCouldMeet(), peopleCouldMeetBefore/2);
		}
		else
		{
			assertEquals(person.getPeopleCouldMeet(), peopleCouldMeetBefore);
		}
		
		assertEquals(person.getPeopleCouldMeet(), peopleCouldMeetBefore/(restriction.getTimeRestriction()/2));
	}
	
	@Test (expected = NullSimulationException.class)
	public void deleteTestException()
	{
		Assume.assumeTrue(s == null);
		
		s.run();
	}
	
	@Test
	public void deleteTest() //I need the DB
	{
		/*s.deleteResults();

	    rowCount = Ebean.find(User.class).where().eq("id", 1).findRowCount();
	    assertEquals(0, rowCount);*/
	}
	
	@After
	public void finish()
	{
		parameters = null;
		s = null;
		person = null;
		results = null;
		area = null;
		region = null;
		restriction = null;
		population = null;
	}
}
