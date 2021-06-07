package CyberPunkReas.CovidSimulator.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Restriction {

    @Id
    @GeneratedValue
    private int id;
    private boolean curfew;
    private boolean businessEssentialClosed;
    private boolean businessNonEssentialClosed;
    private int timeRestriction;
    private boolean mobility;

    public Restriction() {
        this.curfew = false;
        this.businessEssentialClosed = false;
        this.businessNonEssentialClosed = false;
        this.timeRestriction = 0;
        this.mobility = false;
    }

    public Restriction(boolean curfew, boolean businessE, boolean businessNE, int timeRestriction, boolean mobility) {
        this.curfew = curfew;
        this.businessEssentialClosed = businessE;
        this.businessNonEssentialClosed = businessNE;
        this.timeRestriction = timeRestriction;
        this.mobility = false;
    }

    //Getters are created in case they are needed for RestrictionTest.java

    public boolean isCurfew() {
        return curfew;
    }

    public void setCurfew(boolean curfew) {
        this.curfew = curfew;
    }

    public int getTimeRestriction() {
        return timeRestriction;
    }

    public void setTimeRestriction(int timeSpan) throws RuntimeException {
        if (timeSpan < 2 | timeSpan >= 8) {
            throw new RuntimeException("Time Restriction parameter out of bounds");
        }
        this.timeRestriction = timeSpan;
    }

    public void setMobilityAllow(boolean mobility) {
        this.mobility = mobility;
    }

    public void setBusinessClosed(boolean essentialClose, boolean nonessentialClose) {
        this.businessEssentialClosed = essentialClose;
        if (essentialClose) {
            this.businessNonEssentialClosed = true;
        } else {
            this.businessNonEssentialClosed = nonessentialClose;
        }
    }

    public boolean isBusinessEssentialClosed() {
        return businessEssentialClosed;
    }

    public void setBusinessEssentialClosed(boolean businessEssentialClosed) {
        this.businessEssentialClosed = businessEssentialClosed;
    }

    public boolean isBusinessNonEssentialClosed() {
        return businessNonEssentialClosed;
    }

    public void setBusinessNonEssentialClosed(boolean businessNonEssentialClosed) {
        this.businessNonEssentialClosed = businessNonEssentialClosed;
    }

    public boolean isMobility() {
        return mobility;
    }

    public void setMobility(boolean mobility) {
        this.mobility = mobility;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}