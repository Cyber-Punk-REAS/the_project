package CyberPunkReas.CovidSimulator.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Simulation {
    private int averageFriends;
    private int friendsStandardDeviation;
    private int unemployment;
    private int immunityChance;
    @Id
    @GeneratedValue
    private Long id;

    public int getAverageFriends() {
        return averageFriends;
    }

    public void setAverageFriends(int averageFriends) {
        this.averageFriends = averageFriends;
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

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
