import org.junit.*;

import javax.swing.plaf.synth.Region;
import java.util.Random;

import static org.mockito.Mockito.mock;


public class ResultTest {
    Result r = null;
    Random d = new Random();
    Region region;
    /**
     * This function should set a Result to use it in testing
     */
    @Before
    public void startTestOfResultsClass(){
        r = new Result();
        region = mock(Region.class);
    }

    /**
     * This function check whether the parameters that the constructor receives are correct.
     */

    @Test
    public void testOfCreationAResultsWithCorrectParameters(){
        Assume.assumeNotNull(r);
        Assert.assertTrue(r.getRegion() instanceof Region );
        //And like this with all parameters of results but I dont know which are.
    }

    /**
     * This function check whether the list of days is created correctly i.e. is not null
     * and each day has the number of infected persons.
     */
    @Test
    public void afterCreationResultsTheListOfDaysShouldNotBeNull(){
        Assume.assumeNotNull(r);
        Assert.assertNotNull(r.getListDays());
    }


    /**
     *This function check whether the list of days is created with positive number, i.e. have 0 or more infected
     * persons.
     */
    @Test
    public void afterCreationResultsTheListOfDaysShoudlHaveAPositiveNumber(){
        Assert.assertTrue(r.getListDays().get(d.nextInt(r.getListDays().size())) >= 0);
        Assert.assertFalse(r.getListDays().get(d.nextInt(r.getListDays().size())) < 0);
    }

    /**
     * This check whether de number of days is a negative number.
     */
    @Test
    public void afterCreationResultsShouldHaveAPositiveNumberOfDays(){
        Assume.assumeNotNull(r);
        Assert.assertFalse(r.getnDays() <= 0);
    }

    /**
     *Check if the number of infected person of each day is a number >= 0.
     */
    @Test
    public void testGetInfectedPersons(){
        Assume.assumeNotNull(r);
        Assert.assertTrue(r.getInfectedPersons(d.nextInt(r.getnDays()))>=0);
        Assert.assertNotEquals(r.getInfectedPersons(r.getListDays().get(0)), -1);
        Assert.assertFalse(r.getInfectedPersons(d.nextInt(r.getnDays()))<=0);
    }


    @After
    public void finish(){
        r = null;
    }
}
