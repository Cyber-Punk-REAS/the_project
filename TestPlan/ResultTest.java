import org.junit.*;

import java.util.Random;

public class ResultTest {
    Result r = null;
    Random d = new Random();
    /**
     * This function should set a Result to use it in testing
     */
    @BeforeClass
    public void init(){

    }

    /**
     * This function check whether the list of days is created correctly i.e. is not null
     * and each day has the number of infected persons.
     */
    @Test
    public void testSetListDay(){
        Assert.fail("not finished yet");
    }

    /**
     * This check whether de number of days is a negative number.
     */
    @Test
    public void testGetNdays(){
        Assert.fail("Not finished yet");
    }

    /**
     *Check if the number of infected person of each day is a number >= 0.
     */
    @Test
    public void testGetInfectedPersons(){
        Assert.assertTrue(r.getInfectedPersons(d.nextInt(r.getnDays()))>=0);
        Assert.assertNotEquals(null,r.listDays.get(d.nextInt(r.getnDays()-1)));
        Assert.assertFalse(r.listDays.get(0) == -1);
        //not completed.
    }


    @After
    public void finish(){
        r = null;
    }
}
