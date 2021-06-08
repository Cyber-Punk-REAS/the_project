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
        if (timeSpan < 0 || timeSpan >= 10) {
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