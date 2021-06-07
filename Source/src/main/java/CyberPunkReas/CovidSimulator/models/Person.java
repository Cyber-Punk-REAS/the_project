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

	private Random random = new Random();
	@ManyToOne
	private Area area;
	private boolean startingImmunity;
	private boolean alive;
	private boolean employed;

	private double contagiousness;
	@ManyToOne
	private Business business;
	@ManyToMany
	private List<Person> friends;

	public void setBusiness(Business business){
		if(employed)
			this.business = business;
		else
			this.business = null;
	}

	public void setStartingImmunity(ParameterProfile param){
		if(random.nextInt(100) < param.getImmunityChance())
			startingImmunity = true;
	}

	public void setWork(ParameterProfile param){
		if(random.nextInt(100) > param.getUnemployment())
			employed = true;
	}

	public void setFriends(ParameterProfile param, List<Person> people){
		for(int i = 0; i < Person.rndFriends(param); i++)
			friends.set(i, people.get(random.nextInt(people.size())));
	}


	private static int rndFriends(ParameterProfile param){
		Random rnd = new Random();

		return (int) ((rnd.nextGaussian() + param.getAverageFriends()) * param.getFriendsStandardDeviation());
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
  
  public int getId() {
		return id;
	}

	public Area getArea() {
		return area;
	}

	public boolean isStartingImmunity() {
		return startingImmunity;
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

	public void setContagiousness(double contagiousness) {
		this.contagiousness = contagiousness;
	}

	public void setFriends(List<Person> friends) {
		this.friends = friends;
	}
}
