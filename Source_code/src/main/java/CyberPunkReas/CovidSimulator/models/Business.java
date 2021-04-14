package CyberPunkReas.CovidSimulator.models;

import javax.persistence.Entity;

@Entity
public class Business {
	
	private BusinessType type;
	private int maxPeople;
	private boolean isIndoors;
	
	public BusinessType getType() 
	{
		return type;
	}
	
	public int getMaxPeople() 
	{
		return maxPeople;
	}
	
	public boolean isIndoors() 
	{
		return isIndoors;
	}

	public void setType(BusinessType type) 
	{
		this.type = type;
	}
	
	public void setMaxPeople(int maxPeople) 
	{
		this.maxPeople = maxPeople;
	}
	
	public void setIndoors(boolean isIndoors) 
	{
		this.isIndoors = isIndoors;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isIndoors ? 1231 : 1237);
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Business other = (Business) obj;
		if (isIndoors != other.isIndoors)
			return false;
		if (type != other.type)
			return false;
		return true;
	}
}
