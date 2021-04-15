package CyberPunkReas.CovidSimulator.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Business {
	@Id
	@GeneratedValue
	private Integer id;
	private boolean isEsential;
	private int maxPeople;
	private boolean isIndoors;
	
	public Business(Integer id, boolean esential, int maxPeople, boolean indoors)
	{
		this.id = id;
		this.isEsential = esential;
		this.maxPeople = maxPeople;
		this.isIndoors = indoors;
	}
	
	public Integer getId()
	{
		return this.id;
	}
	
	public boolean getType() 
	{
		return isEsential;
	}
	
	public int getMaxPeople() 
	{
		return maxPeople;
	}
	
	public boolean isIndoors() 
	{
		return isIndoors;
	}
	
	public void setId(Integer id)
	{
		this.id = id;
	}

	public void setType(boolean isEsential) 
	{
		this.isEsential = isEsential;
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
		result = prime * result + (isEsential ? 1231 : 1237);
		result = prime * result + (isIndoors ? 1231 : 1237);
		result = prime * result + maxPeople;
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
		if (isEsential != other.isEsential)
			return false;
		if (isIndoors != other.isIndoors)
			return false;
		if (maxPeople != other.maxPeople)
			return false;
		return true;
	}
	
}
