package CyberPunkReas.CovidSimulator.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Entity
public class Person {
	@Id
	@GeneratedValue
	private int id;

	private static Random random = new Random();
	private int contagiousDays;
	private int maxContagiousDays;
	@ManyToOne
	private Area area;
	private boolean immunity;
	private boolean alive;
	private boolean employed;
	private double contagiousness;
	private double mortalityChance;

	@ManyToOne
	private Business business;
	@ManyToMany
	private List<Person> friends = new ArrayList<>();

	public Person(Area area){
		this.area = area;
		this.immunity = false;
		this.employed = false;
		this.alive = true;
		contagiousDays = 0;
	}

	public Person(Area area, ParameterProfile param, Business business){
		this.area = area;
		this.alive = true;
		contagiousDays = 0;
		setStartingImmunity(param);
		setWork(param);
		setBusiness(business);
		setContagiousness(param);
		setMortalityChance(param);
		setMaxContagiousDays(param);
		// Set friends is than in area after initializing the population
	}

	public Person() {

	}


	public void setBusiness(Business business){
		if(employed)
			this.business = business;
		else
			this.business = null;
	}

	public void setStartingImmunity(ParameterProfile param){
		if(random.nextInt(100) < param.getImmunityChance())
			immunity = true;
	}

	public void survived() {
		immunity = true;
		contagiousness = 0;
	}

	public void setWork(ParameterProfile param){
		if(random.nextInt(100) > param.getUnemployment())
			employed = true;
	}

	public void setFriends(ParameterProfile param, List<Person> people){
		for(int i = 0; i < Person.rndFriends(param); i++)
			friends.add(people.get(random.nextInt(people.size())));
	}

	public void setContagiousness(ParameterProfile param) {
		if (random.nextInt(100) < param.getInitialInfectedPeople()) {
			this.contagiousness = ((random.nextGaussian() * param.getContagiousnessStandardDeviation() + param.getAverageContagiousness()));
		} else {
			this.contagiousness = 0;
		}
	}
	
	public void setMortalityChance(ParameterProfile param) {
		this.mortalityChance = ((random.nextGaussian() * param.getMortalityStandardDeviation() + param.getMortalityRate()));
	}

	public void setMaxContagiousDays(ParameterProfile param) {
		this.maxContagiousDays = (int) ((random.nextGaussian() * param.getContagiousnessStandardDeviation() + param.getAverageContagiousDays()));
	}

	public static int rndFriends(ParameterProfile param){
		int friends = (int) ((random.nextGaussian() + 15));
		return friends;
	}

	public List<Person> getPeopleCouldMeet() {
		List<Person> peopleCouldMeet = new ArrayList<>();
		for(Person friend: friends) {
			if(area.getRestrictionPolicy().isCurfew() && friend.alive) {
				if(friend.getArea().getId() == area.getId())
					peopleCouldMeet.add(friend);
			}
			else {
				if(!friend.getArea().getRestrictionPolicy().isCurfew() && friend.alive)
					peopleCouldMeet.add(friend);
			}
		}
		return peopleCouldMeet;
	}

	public void incrementContagiousDays() {
		contagiousDays++;
	}

	public int getId() {
		return id;
	}

	public Area getArea() {
		return area;
	}

	public int getContagiousDays() {
		return contagiousDays;
	}

	public int getMaxContagiousDays() {
		return maxContagiousDays;
	}
	
	public double getMortalityChance() {
		return mortalityChance;
	}
	
	public boolean isImmunity() {
		return immunity;
	}

	public boolean isAlive() {
		return alive;
	}

	public boolean isEmployed() {
		return employed;
	}

	public Business getBusiness() {
		return business;
	}

	public double getContagiousness() {
		return contagiousness;
	}

	public List<Person> getFriends() {
		return friends;
	}

	public void died() {
		alive = false;
		contagiousness = 0;
	}
}
