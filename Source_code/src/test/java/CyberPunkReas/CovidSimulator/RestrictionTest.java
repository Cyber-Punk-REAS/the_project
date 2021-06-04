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

    // Tests whether the setter setBusinessEssential works correctly given it's parameters
    @Test
    void testSetBusinessEssential() {
        r.setBusinessEssential(true);
        assertEquals(true, r.isBusinessEssential());
        r.setBusinessEssential(false);
        assertEquals(false, r.isBusinessEssential());
        // If Essential businesses are closed, non-essential businesses should be closed too.
        assertEquals(false, r.isBusinessNonEssential());
    }

    // Tests whether the setter setBusinessNonEssential works correctly given it's parameters
    @Test
    void testSetBusinessNonEssential() {
        fail("Not implemented");
        r.setBusinessNonEssential(false);
        assertEquals(false, r.isBusinessNonEssential());
        r.setBusinessNonEssential(true);
        assertEquals(true, r.isBusinessNonEssential());
    }

    // Tests whether the setter setTimeRestriction works correctly given it's parameters
    @Test
    void testSetTimeRestriction() {
        r.setTimeRestriction(0);
        assertEquals(0, r.getTimeRestriction());
        r.setTimeRestriction(12);
        assertEquals(12, r.getTimeRestriction());
        r.setTimeRestriction(24);
        assertEquals(24, r.getTimeRestriction());
    }

    @Test(expected = RuntimeException.class)
    void testSetTimeRestrictionUpperBound() {
        r.setTimeRestriction(60);
    }

    @Test(expected = RuntimeException.class)
    void testSetTimeRestrictionLowerBound() {
        r.setTimeRestriction(-20);
    }
}
