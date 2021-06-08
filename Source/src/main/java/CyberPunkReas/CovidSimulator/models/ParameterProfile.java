package CyberPunkReas.CovidSimulator.models;

import java.util.Random;

public class ParameterProfile {
	private static final int MORTALITY_RATE = 2; // 2% mortality rate
	private int averageContagiousDays,
				averageContagiousness,
				averageDaysContagious,
				averageFriends,
				executionTime,
				immunityChance,
				initialInfectedPeople,
				mortalityRate = MORTALITY_RATE, 
				unemployment;
	private Random random = new Random();
	
	public ParameterProfile(int averageContagiousDays, int averageContagiousness, int averageDaysContagious, int averageFriends, int executionTime, int immunityChance, int initialInfectedPeople, int unemployment) {
		this.averageContagiousDays = averageContagiousDays;
		this.averageContagiousness = averageContagiousness;
		this.averageDaysContagious = averageDaysContagious;
		this.averageFriends = averageFriends;
		this.executionTime = executionTime;
		this.immunityChance = immunityChance;
		this.initialInfectedPeople = initialInfectedPeople;
		this.unemployment = unemployment;
	}
	
	public int getAverageContagiousDays() {
		return averageContagiousDays;
	}
	
	public int getAverageContagiousness() {
		return averageContagiousness;
	}
	
	public int getAverageFriends() {
		return averageFriends;
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
	
	public double getMortalityStandardDeviation() {
		return mortalityRate/3; // Greater the number of friends, greater the standard deviation
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
	
	public int getMortalityRate() {
		return mortalityRate;
	}

	public int getDaysContagious(){
		return (int) (random.nextGaussian() + this.averageDaysContagious) * 3;
	}
	
	public void setAverageContagiousDays(int averageContagiousDays) {
		this.averageContagiousDays = averageContagiousDays;
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
