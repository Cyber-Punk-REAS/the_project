package CyberPunkReas.CovidSimulator.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Person {
	@Id
	@GeneratedValue
	private Integer dni;
	private int age;
	private boolean isImmune;
	private float ChInfect;
	private float ChInfected;
	private float ChToGoOutAtNight;
	private int businessVisited;
	
	@ManyToOne
	private Region region;
	
	public Person(Integer dni, int age, boolean isImmune, float chInfect, float chInfected, float chToGoOutAtNight, int businessVisited) {
		this.dni = dni;
		this.age = age;
		this.isImmune = isImmune;
		ChInfect = chInfect;
		ChInfected = chInfected;
		ChToGoOutAtNight = chToGoOutAtNight;
		this.businessVisited = businessVisited;
	}
	
	
	
	public Region getRegion() {
		return region;
	}

	public Integer getDni() {
		return dni;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public boolean isImmune() {
		return isImmune;
	}
	
	public float getChInfect() {
		return ChInfect;
	}
	
	public float getChInfected() {
		return ChInfected;
	}
	
	public float getChToGoOutAtNight() {
		return ChToGoOutAtNight;
	}
	
	public int getBusinessVisited() {
		return businessVisited;
	}
	
	public void setImmune(boolean isImmune) {
		this.isImmune = isImmune;
	}
	
	public void setChInfect(float chInfect) {
		ChInfect = chInfect;
	}
	
	public void setChInfected(float chInfected) {
		ChInfected = chInfected;
	}
	
	public void setChToGoOutAtNight(float chToGoOutAtNight) {
		ChToGoOutAtNight = chToGoOutAtNight;
	}
	
	public void setBusinessVisited(int businessVisited) {
		this.businessVisited = businessVisited;
	}
	
	public void setRegion(Region region) {
		this.region = region;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Person [DNI = " + dni + ", Age = " + age + ", isImmune = " + isImmune + ", Chance to infect = " + ChInfect
				+ ", Chance to be infected=" + ChInfected + ", Chance to go out at night = " + ChToGoOutAtNight + ", business visited per day = "
				+ businessVisited + "]";
	}
	
	
}
