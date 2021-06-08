package CyberPunkReas.CovidSimulator.models;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.*;

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
	@ManyToOne
	private Business business;
	@ManyToMany
	private List<Person> friends;

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
			friends.set(i, people.get(random.nextInt(people.size())));
	}

	public void setContagiousness(ParameterProfile param) {
		this.contagiousness = ((random.nextGaussian() + param.getAverageContagiousness()) * param.getContagiousnessStandardDeviation());
	}

	public void setMaxContagiousDays(ParameterProfile param) {
		this.maxContagiousDays = (int) ((random.nextGaussian() + param.getAverageContagiousDays()) * param.getContagiousDaysStandardDeviation());
	}

	private static int rndFriends(ParameterProfile param){
		return (int) ((random.nextGaussian() + param.getAverageFriends()) * param.getFriendsStandardDeviation());
	}

	public List<Person> getPeopleCouldMeet() {
		List<Person> peopleCouldMeet = new ArrayList<>();
		for(Person friend: friends) {
			if(area.getRestrictionPolicy().isCurfew()) {
				if(friend.getArea().getId() == area.getId())
					peopleCouldMeet.add(friend);
			}
			else {
				if(!friend.getArea().getRestrictionPolicy().isCurfew())
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
}
