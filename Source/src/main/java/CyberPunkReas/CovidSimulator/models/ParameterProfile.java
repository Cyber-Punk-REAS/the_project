package CyberPunkReas.CovidSimulator.models;

public class ParameterProfile {
	private int averageFriends,
				friendsStandardDeviation,
				unemployment,
				immunityChance,
				executionTime,
				initialInfectedPeople;
	
	public ParameterProfile(int averageFriends, int executionTime, int friendsStandardDeviation, 
			int immunityChance, int initialInfectedPeople, int unemployment) {
		this.averageFriends = averageFriends;
		this.executionTime = executionTime;
		this.friendsStandardDeviation = friendsStandardDeviation;
		this.immunityChance = immunityChance;
		this.initialInfectedPeople = initialInfectedPeople;
		this.unemployment = unemployment;
	}
	
	public int getAverageFriends() {
		return averageFriends;
	}

	public int getFriendsStandardDeviation() {
		return friendsStandardDeviation;
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

	public void setAverageFriends(int averageFriends) {
		this.averageFriends = averageFriends;
	}

	public void setFriendsStandardDeviation(int friendsStandardDeviation) {
		this.friendsStandardDeviation = friendsStandardDeviation;
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
