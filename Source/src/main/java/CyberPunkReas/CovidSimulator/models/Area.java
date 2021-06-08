package CyberPunkReas.CovidSimulator.models;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Entity
public class Area {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int populationSize;
    private int size;
    private int numberOfBusiness;
    @ManyToOne
    private Restriction restrictionPolicy;
    @OneToMany()
    private List<Business> businesses;
    @OneToMany
    private List<Person> population;

	public int getPopulationSize() {
		return populationSize;
	}

	public int getSize() {
		return size;
	}

	public int getNumberOfBusiness() {
		return numberOfBusiness;
	}

	public void setPopulationSize(int populationSize) {
		this.populationSize = populationSize;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setNumberOfBusiness(int numberOfBusiness) {
		this.numberOfBusiness = numberOfBusiness;
	}

	public List<Person> getPopulation() {
        return population;
    }
    
    public void setPopulation(ParameterProfile param) {
    	Random rnd = new Random();
    	population = new ArrayList<>();
    	for(int i = 0; i < populationSize; i++) {
    		Person p = new Person(this, param, businesses.get(rnd.nextInt(businesses.size())));
    		population.add(p);
    	}
    	for(Person p : population) {
    		p.setFriends(param, population);
    	}
    }
    
    public void setPopulation(List<Person> areaPopulation) {
        population = areaPopulation;
    }

    public Restriction getRestrictionPolicy() {
        return restrictionPolicy;
    }

    public void setRestrictionPolicy(Restriction restrictionPolicy) {
        this.restrictionPolicy = restrictionPolicy;
    }

    public List<Business> getBusinesses() {
        return businesses;
    }
    
    public void setBusinesses() {
    	businesses = new ArrayList<>();
    	Random rnd = new Random();
    	for(int i = 0; i < numberOfBusiness; i++) {
    		boolean essential = (rnd.nextBoolean());
    		Business b = new Business(i, essential, this);
    		businesses.add(b);
    	}
    }
    
    public void setBusinesses(List<Business> businesses) {
        this.businesses = businesses;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}