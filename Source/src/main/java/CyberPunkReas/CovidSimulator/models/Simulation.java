package CyberPunkReas.CovidSimulator.models;

import java.util.List;

public class Simulation {
	
	private int NBeginningInfected;
	private List<Region> regions;
	private List<Restriction> restrictions;
	private int NDays;
	
	public Simulation(int peopleInfectedBeginning, List<Region> regions, List<Restriction> restrictions, int nDays)
	{
		this.NBeginningInfected = peopleInfectedBeginning;
		this.regions = regions;
		this.restrictions = restrictions;
		this.NDays = nDays;
	}
	
	
	
	public List<Restriction> getRestrictions() {
		return restrictions;
	}

	public int getNBeginningInfected() {
		return NBeginningInfected;
	}

	public List<Region> getRegions() {
		return regions;
	}

	public int getNDays() {
		return NDays;
	}

	public void setNBeginningInfected(int nBeginningInfected) {
		NBeginningInfected = nBeginningInfected;
	}

	public void setRegions(List<Region> regions) {
		this.regions = regions;
	}

	public void setNDays(int nDays) {
		NDays = nDays;
	}
	
	public void setRestrictions(List<Restriction> restrictions) {
		this.restrictions = restrictions;
	}
	
	//OTHER METHODS
	public void BeginSim(int nDays)
	{
		//IT RETURNS A LIST OF DAYS
	}
	
	public void AddRestriction(Restriction res)
	{
		//Adds a restriction to the List.
	}
	
	public void CloseRegions()
	{
		
	}
}
