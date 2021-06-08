package CyberPunkReas.CovidSimulator.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.Random;

@Entity
public class ParameterProfile {
  private static final int MORTALITY_RATE = 2; // 2% mortality rate
  @Id
  @GeneratedValue
	private int id;

	private int averageContagiousDays;
	private int averageContagiousness;
	private int averageFriends;
	private int unemployment;
	private int immunityChance;
	private int executionTime;
	private int initialInfectedPeople;
	private int mortalityRate = MORTALITY_RATE;

	private static Random random = new Random();

	public int getExecutionTime() {
		return executionTime;
	}

	public void setExecutionTime(int executionTime) {
		this.executionTime = executionTime;
	}

	public int getInitialInfectedPeople() {
		return initialInfectedPeople;
	}

	public void setInitialInfectedPeople(int initialInfectedPeople) {
		this.initialInfectedPeople = initialInfectedPeople;
	}

	public int getImmunityChance() {
		return immunityChance;
	}

	public void setImmunityChance(int immunityChance) {
		this.immunityChance = immunityChance;
	}

	public double getMortalityStandardDeviation() {
		return mortalityRate/3; // Greater the number of friends, greater the standard deviation
	}

	public int getUnemployment() {
		return unemployment;
	}

	public void setUnemployment(int unemployment) {
		this.unemployment = unemployment;
	}

	public int getAverageFriends() {
		return averageFriends;
	}

	public void setAverageFriends(int averageFriends) {
		this.averageFriends = averageFriends;
	}
	
	public int getMortalityRate() {
		return mortalityRate;
	}

	public int getAverageContagiousness() {
		return averageContagiousness;
	}

	public void setAverageContagiousness(int averageContagiousness) {
		this.averageContagiousness = averageContagiousness;
	}

	public int getAverageContagiousDays() {
		return averageContagiousDays;
	}

	public void setAverageContagiousDays(int averageContagiousDays) {
		this.averageContagiousDays = averageContagiousDays;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
  
	public double getContagiousDaysStandardDeviation() {
		return averageContagiousDays/4; // Greater the number of contagious days, greater the standard deviation
	}
  
	public double getContagiousnessStandardDeviation() {
		return averageContagiousness/5; // Greater the contagiousness, greater the standard deviation
	}

	public int getFriendsStandardDeviation() {
		return averageFriends/3; // Greater the number of friends, greater the standard deviation
	}
}
