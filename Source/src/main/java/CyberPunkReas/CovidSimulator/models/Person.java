package CyberPunkReas.CovidSimulator.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Person {
	@Id
	@GeneratedValue

	@ManyToOne
	private static int _id_ = 0;
	private Random random = new Random();
	private int id;
	private Area area;
	private boolean startingImmunity;
	private boolean alive;
	private boolean employed;
	private Business business;
	private double contagiousness;
	private Person[] friends;

	public Person(Area area){
		this.id = Person._id_++;
		this.area = area;
		this.startingImmunity = false;
		this.employed = false;
		this.alive = true;
	}
	
	public Person(Area area, int immunityChance, int unemployment, Business business){
		this.id = Person._id_++;
		this.area = area;
		this.alive = true;
		setStartingImmunity(immunityChance);
		setWork(unemployment, Business business);
		setBusiness(business);
	}

	public void setBusiness(Business business){
		if(employed)
			this.business = business;
		else
			this.business = null;
	}

	public void setStartingImmunity(int immunityChance){
		if(random.nextInt(100) < immunityChance)
			startingImmunity = true;
	}

	public void setWork(int unemployment){
		if(random.nextInt(100) > unemployment)
			employed = true;
	}

	public void setFriends(double averageFriends, double friendsStandardDeviation, List<Person> people){
		for(int i = 0; i < Person.rndFriends( averageFriends, friendsStandardDeviation); i++)
			friends[i] = people.get(random.nextInt(people.size()));
	}


	private static int rndFriends(double averageFriends, double friendsStandardDeviation){
		Random rnd = new Random();

		return (int) ((rnd.nextGaussian() + averageFriends) * friendsStandardDeviation);    
	}

	public ArrayList<Person> getPeopleCouldMeet() {
		ArrayList<Person> peopleCouldMeet = new ArrayList<>();
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

	public Person[] getFriends() {
		return friends;
	}

	
}
