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
	private int edad;
	private boolean isInmune;
	private float ChInfect;
	private float ChInfected;
	private float ChToGoOutAtNight;
	private int businessVisited;
	
	@ManyToOne
	private Region region;
	
	public Person(Integer dni, int edad, boolean isInmune, float chInfect, float chInfected, float chToGoOutAtNight, int businessVisited) {
		this.dni = dni;
		this.edad = edad;
		this.isInmune = isInmune;
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
	
	public int getEdad() {
		return edad;
	}
	
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public boolean isInmune() {
		return isInmune;
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
	
	public void setInmune(boolean isInmune) {
		this.isInmune = isInmune;
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
		return "Person [DNI = " + dni + ", Edad = " + edad + ", isInmune = " + isInmune + ", Chance to infect = " + ChInfect
				+ ", Chance to be infected=" + ChInfected + ", Chance to go out at night = " + ChToGoOutAtNight + ", business visited per day = "
				+ businessVisited + "]";
	}
	
	
}
