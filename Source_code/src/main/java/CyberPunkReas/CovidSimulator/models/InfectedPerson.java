package CyberPunkReas.CovidSimulator.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class InfectedPerson extends Person {

    @Id
    @GeneratedValue
    private int daysUntilCured;
    private boolean isQuarantined;
    private double chanceOfDeath;
    private boolean isDead;

    public InfectedPerson(Integer dni, int age, boolean isImmune, float chInfect, float chInfected, float chToGoOutAtNight, int businessVisited, int daysUntilCured, boolean isQuar, double chanceDeath, boolean isDead) {
        super(dni, age, isImmune, chInfect, chInfected, chToGoOutAtNight, businessVisited);
        this.daysUntilCured = daysUntilCured;
        this.isQuarantined = isQuar;
        this.chanceOfDeath = chanceDeath;
        this.isDead = isDead;
    }

    public int getDaysUntilCured() { return this.daysUntilCured; }

    public boolean getIsQuarantined() { return isQuarantined; }

    public double getChanceOfDeath() { return this.chanceOfDeath; }

    public boolean getIsDead() { return this.isDead; }

    public void setDaysUntilCured(int daysUntilCured) { this.daysUntilCured = daysUntilCured; }

    public void setQuarantined(boolean isQuarantined) { this.isQuarantined = isQuarantined; }

    public void setChanceOfDeath(double chanceOfDeath) { this.chanceOfDeath = chanceOfDeath; }

    public void setDead(boolean isDead) { this.isDead = isDead; }

    public String toString() {
        return "InfectedPerson [DNI = " + super.getDni() + ", Age = " + super.getAge() + ", isImmune = " + super.isImmune() + ", Chance to infect = " + super.getChInfect()
                + ", Chance to be infected=" + super.getChInfected() + ", Chance to go out at night = " + super.getChToGoOutAtNight() + ", business visited per day = "
                + super.getBusinessVisited() + ", Days Until Cured = " + this.daysUntilCured + ", isQuarantined = " + this.isQuarantined + ", Chance of Dying = "
                + this.chanceOfDeath + ", isDead = " + this.isDead + "]";
    }
}
