package CyberPunkReas.CovidSimulator.models;

import java.util.ArrayList;


class Area {
	
	private int AreaId;
	private ArrayList<Person> AreaPopulation ;
	private ArrayList<Business> Areabusiness;
	private ArrayList<RestrictionPolicy> AreaRestrictionPolicy;
	
	public Area(int AreaId, ArrayList<Person> AreaPopulation, ArrayList<Business> AreaBusiness, ArrayList<RestrictionPolicy> AreaRestrictionPolicy) {
		
		setAreaId(AreaId);
		setAreaPopulation(AreaPopulation);
		setAreabusiness(AreaBusiness);
		setAreaRestrictionPolicy(AreaRestrictionPolicy);
		
	}

	public ArrayList<Person> getAreaPopulation() {
		return AreaPopulation;
	}

	public void setAreaPopulation(ArrayList<Person> areaPopulation) {
		AreaPopulation = areaPopulation;
	}

	public ArrayList<RestrictionPolicy> getAreaRestrictionPolicy() {
		return AreaRestrictionPolicy;
	}

	public void setAreaRestrictionPolicy(ArrayList<RestrictionPolicy> areaRestrictionPolicy) {
		AreaRestrictionPolicy = areaRestrictionPolicy;
	}

	public ArrayList<Business> getAreabusiness() {
		return Areabusiness;
	}

	public void setAreabusiness(ArrayList<Business> areabusiness) {
		Areabusiness = areabusiness;
	}

	public int getAreaId() {
		return AreaId;
	}

	public void setAreaId(int areaId) {
		AreaId = areaId;
	}

	

	
	public void unlinkRestrictionPolicy(int PolicyId) {
		
		for(RestrictionPolicy thisRestriction : this.AreaRestrictionPolicy )
		{
			int thisId =  thisRestriction.getRestrictionPolicyId();
			if(thisId == PolicyId)
				this.AreaRestrictionPolicy.remove(thisRestriction);
		}
		
		
	}
	



}
