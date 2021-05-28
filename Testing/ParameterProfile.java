package testing;

import java.util.Random;

public class ParameterProfile {
	
	private int startingImmunityChance;
    private double averageFriends;
    private int averageDaysContagious;
    private int daysForSimulation;
    private int unemployment;
    private Random random = new Random();

    public int getStartingImmunityChance() {
        return startingImmunityChance;
    }

    public int getUnemployment() {
        return unemployment;
    }

    public double getFriendsStandardDeviation() {
        return averageFriends / 3;
    }

    public double getAverageFriends() {
        return averageFriends;
    }

    public int getDaysContagious(){
        return (int) (random.nextGaussian() + this.averageDaysContagious) * 3;
    }
    
    public int getDaysForSimulation()
    {
    	return this.daysForSimulation;
    }
}
