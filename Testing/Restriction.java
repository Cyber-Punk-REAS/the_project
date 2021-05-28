package testing;

public class Restriction {
	
	private boolean curfew;
	private int timeRestriction;
	
	public void setCurfew(boolean curfew)
	{
		this.curfew = true;
	}
	
	public void setTimeRestriction(int timeSpan)
	{
		this.timeRestriction = timeSpan;
	}
	
	public boolean getCurfew()
	{
		return this.curfew;
	}
	
	public int getTimeRestriction()
	{
		return this.timeRestriction;
	}
}
