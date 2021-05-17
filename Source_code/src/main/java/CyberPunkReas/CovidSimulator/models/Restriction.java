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

    public void setTimeRestriction(int timeSpan) {
        this.timeRestriction = timeSpan;
    }

}
