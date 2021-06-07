package CyberPunkReas.CovidSimulator.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ParameterProfile {
	@Id
    @GeneratedValue
	private int id;
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

    public ParameterProfile() {

    }

	public int getAverageFriends() {
		return averageFriends;
	}

	public void setAverageFriends(int averageFriends) {
		this.averageFriends = averageFriends;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFriendsStandardDeviation() {
		return friendsStandardDeviation;
	}

	public void setFriendsStandardDeviation(int friendsStandardDeviation) {
		this.friendsStandardDeviation = friendsStandardDeviation;
	}

	public int getUnemployment() {
		return unemployment;
	}

	public void setUnemployment(int unemployment) {
		this.unemployment = unemployment;
	}

	public int getImmunityChance() {
		return immunityChance;
	}

	public void setImmunityChance(int immunityChance) {
		this.immunityChance = immunityChance;
	}

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
}
