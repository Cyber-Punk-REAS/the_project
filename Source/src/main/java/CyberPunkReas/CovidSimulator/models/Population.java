package CyberPunkReas.CovidSimulator.models;

import java.util.ArrayList;

public class Population {
	
	private int populationID;

	private int populationSize;
	
	private ArrayList<Person> people;
	
	private int AreaAffectedID;
	
	
	public Population(int ID, int AreaID) 
	{
		this.populationID = ID;
		this.AreaAffectedID = AreaID;
		this.people = new ArrayList<Person>();
		this.populationSize = 0;
	}
	
	public Population(int ID, int AreaId, ArrayList<Person> persons)
	{
		this.populationID = ID;
		this.setAreaAffectedID(AreaId);
		this.populationSize = persons.size();
		this.people = persons;
		
		
	}
	
	
	public Population getPopulation()
	{
		return this;
	}
	
	public int getPopulationID() {
		return populationID;
	}

	public void setPopulationID(int populationID) {
		this.populationID = populationID;
	}

	public int getPopulationSize() {
		return populationSize;
	}

	public void setPopulationSize(int populationSize) {
		this.populationSize = populationSize;
	}

	public ArrayList<Person> getPeople() {
		return people;
	}

	public void setPeople(ArrayList<Person> people) {
		this.people = people;
	}

	public int getAreaAffectedID() {
		return AreaAffectedID;
	}



	public void setAreaAffectedID(int areaAffectedID) {
		AreaAffectedID = areaAffectedID;
	}
	
	public void removeSinglePerson(Person person)
	{
		this.people.remove(person);
		
	}
	
	public void addSinglePerson(Person person)
	{
	
		this.people.add(person);
	}
	
	public void removeAllPerson()
	{
		this.people.removeAll(people);
	}

}
