package CyberPunkReas.CovidSimulator;

import static org.junit.jupiter.api.Assertions.*;

import CyberPunkReas.CovidSimulator.models.Restriction;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

public class RestrictionTest {

    private Restriction r;
    // This should create a Restriction which is valid to do the tests with
    @BeforeClass
    void setRestriction() {
        r = new Restriction();
    }

    // Tests whether the setter setCurfew works correctly given it's parameters
    @Test
     void testSetCurfew() {
        r.setCurfew(true);
        assertEquals(true, r.isCurfew());
        r.setCurfew(false);
        assertEquals(false, r.isCurfew());
    }

    // Tests whether the setter setBusinessClosed works correctly given it's parameters
    @Test
    void testSetBusinessClosed() {
        // If Essential businesses are closed, non-essential businesses should be closed too.
        r.setBusinessClosed(true, false);
        assertEquals(true, r.isBusinessEssential());
        assertEquals(true, r.isBusinessNonEssential());
        r.setBusinessClosed(false, false);
        assertEquals(true, r.isBusinessEssential());
        assertEquals(false, r.isBusinessNonEssential());
    }

    // Tests whether the setter setMobility_Allow works correctly given it's parameters
    @Test
    void testSetMobility_Allow() {
        r.setMobility_Allow(true);
        assertEquals(true, r.isMobility_Allowed());
        r.setMobility_Allow(false);
        assertEquals(false, r.isMobility_Allowed());
    }

    // Tests whether the setter setTimeRestriction works correctly given it's parameters
    @Test
    void testSetTimeRestriction() {
        r.setTimeRestriction(2);
        assertEquals(2, r.getTimeRestriction());
        r.setTimeRestriction(4);
        assertEquals(4, r.getTimeRestriction());
        r.setTimeRestriction(8);
        assertEquals(8, r.getTimeRestriction());
    }

    // Expects an exception when upper bound is exceeded
    @Test(expected = RuntimeException.class)
    void testSetTimeRestrictionExceedingUpperBound() {
        r.setTimeRestriction(9);
    }


    // Expects an exception when lower bound is exceeded
    @Test(expected = RuntimeException.class)
    void testSetTimeRestrictionExceedingLowerBound() {
        r.setTimeRestriction(1);
    }
}
