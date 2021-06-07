package CyberPunkReas.CovidSimulator.models;

public class Restriction {

    private boolean curfew;
    private boolean businessEssentialClosed;
    private boolean businessNonEssentialClosed;
    private int timeRestriction;
    private boolean mobility ;
    
    public Restriction() {
        curfew = false;
        businessEssentialClosed = false;
        businessNonEssentialClosed = false;
        timeRestriction = 0;
        mobility =false;
    }
    // Constructor for mockup
    public Restriction(boolean curfew, boolean businessE,boolean businessNE,int timeRestriction, boolean mobility) {
    	this.curfew = curfew;
    	businessEssentialClosed = businessE;
    	businessNonEssentialClosed = businessNE;
    	this.timeRestriction= timeRestriction; 
    	mobility = false;
    }

    //Getters are created in case they are needed for RestrictionTest.java

    public boolean isCurfew() {
        return curfew;
    }

    public boolean isBusinessEssential() {
        return businessEssentialClosed;
    }

    public boolean isBusinessNonEssential() {
        return businessNonEssentialClosed;
    }

    public int getTimeRestriction() {
        return timeRestriction;
    }

    public void setCurfew(boolean curfew) {
        this.curfew = curfew;
    }
    
    public void setMobility_Allow(boolean mobility) {
    	this.mobility=mobility;
    }
    
    public boolean isMobility_Allowed() {
    	return mobility;
    }
    
    public void setBusinessClosed(boolean essentialClose, boolean nonessentialClose) {
    	this.businessEssentialClosed = essentialClose;
    	if(essentialClose) {
    		this.businessNonEssentialClosed=true;
    	}else {
    		this.businessNonEssentialClosed=nonessentialClose;
    	}
    }

    public void setTimeRestriction(int timeSpan) throws RuntimeException {
    	if(timeSpan < 0 | timeSpan > 24) {
    		throw new RuntimeException("Time Restriction parameter out of bounds");
    	}
    	this.timeRestriction = timeSpan;
    }

    /*public void setBusinessEssential(boolean businessEssential) {
        this.businessEssential = businessEssential;
        if(businessEssential = false) { this.businessNonEssential = false; }
    }

    public void setBusinessNonEssential(boolean businessNonEssential) {
        this.businessNonEssential = businessNonEssential;
    }
*/

}
