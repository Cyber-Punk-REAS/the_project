package CyberPunkReas.CovidSimulator.models;

public class Restriction {

    private boolean curfew;
    private boolean businessEssential;
    private boolean businessNonEssential;
    private int timeRestriction;

    public Restriction() {
        curfew = false;
        businessEssential = false;
        businessNonEssential = false;
        timeRestriction = 0;
    }

    //Getters are created in case they are needed for RestrictionTest.java

    public boolean isCurfew() {
        return curfew;
    }

    public boolean isBusinessEssential() {
        return businessEssential;
    }

    public boolean isBusinessNonEssential() {
        return businessNonEssential;
    }

    public int getTimeRestriction() {
        return timeRestriction;
    }

    public void setCurfew(boolean curfew) {
        this.curfew = curfew;
    }

    public void setBusinessEssential(boolean businessEssential) {
        this.businessEssential = businessEssential;
        if(businessEssential = false) { this.businessNonEssential = false; }
    }

    public void setBusinessNonEssential(boolean businessNonEssential) {
        this.businessNonEssential = businessNonEssential;
    }

    public void setTimeRestriction(int timeSpan) throws RuntimeException {
        if(timeSpan < 0 | timeSpan > 24) {
            throw new RuntimeException("Time Restriction parameter out of bounds");
        }
        this.timeRestriction = timeSpan;
    }

}
