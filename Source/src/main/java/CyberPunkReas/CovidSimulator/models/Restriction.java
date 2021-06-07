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

    //Getters are created for RestrictionTest.java

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

    public void setBusiness(boolean businessEssential, boolean businessNonEssential) throws RuntimeException {
        if(! businessEssential && businessNonEssential) { throw new RuntimeException("Invalid restriction parameters"); }
        this.businessEssential = businessEssential;
        this.businessNonEssential = businessNonEssential;
    }

    public void setTimeRestriction(int timeSpan) throws RuntimeException {
        if(timeSpan < 0 | timeSpan > 24) {
            throw new RuntimeException("Time Restriction parameter out of bounds");
        }
        this.timeRestriction = timeSpan;
    }

}
