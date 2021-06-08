package CyberPunkReas.CovidSimulator.models;

import java.util.Random;

public class ParameterProfile {
	private int averageDaysContagious,
				averageFriends,
				unemployment,
				immunityChance,
				executionTime,
				initialInfectedPeople;
	private Random random = new Random();
	
	public ParameterProfile(int averageDaysContagious, int averageFriends, int executionTime, int immunityChance, int initialInfectedPeople, int unemployment) {
		this.averageDaysContagious = averageDaysContagious;
		this.averageFriends = averageFriends;
		this.executionTime = executionTime;
		this.immunityChance = immunityChance;
		this.initialInfectedPeople = initialInfectedPeople;
		this.unemployment = unemployment;
	}
	
	public int getAverageFriends() {
		return averageFriends;
	}

	public int getFriendsStandardDeviation() {
		return averageFriends/3;
	}

	public int getUnemployment() {
		return unemployment;
	}

	public int getImmunityChance() {
		return immunityChance;
	}

	public int getExecutionTime() {
		return executionTime;
	}

	public int getInitialInfectedPeople() {
		return initialInfectedPeople;
	}

	public int getDaysContagious(){
		return (int) (random.nextGaussian() + this.averageDaysContagious) * 3;
	}

	public void setAverageFriends(int averageFriends) {
		this.averageFriends = averageFriends;
	}

	public void setUnemployment(int unemployment) {
		this.unemployment = unemployment;
	}

	public void setImmunityChance(int immunityChance) {
		this.immunityChance = immunityChance;
	}

	public void setExecutionTime(int executionTime) {
		this.executionTime = executionTime;
	}

	public void setInitialInfectedPeople(int initialInfectedPeople) {
		this.initialInfectedPeople = initialInfectedPeople;
	}
	
	
}
