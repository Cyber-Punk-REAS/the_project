package CyberPunkReas.CovidSimulator.models;

public class Restriction {
	
	
	
	private boolean curfew;
	private boolean EssentialBussiness;
	private int timeRestriction;
	
	
	
	public Restriction() {
		
	}



	public boolean isCurfew() {
		return curfew;
	}



	public void setCurfew(boolean curfew) {
		this.curfew = curfew;
	}



	public boolean isEssentialBussiness() {
		return EssentialBussiness;
	}



	public void setEssentialBussiness(boolean essentialBussiness) {
		EssentialBussiness = essentialBussiness;
	}



	public int getTimeRestriction() {
		return timeRestriction;
	}



	public void setTimeRestriction(int timeRestriction) {
		this.timeRestriction = timeRestriction;
	}
    
}
