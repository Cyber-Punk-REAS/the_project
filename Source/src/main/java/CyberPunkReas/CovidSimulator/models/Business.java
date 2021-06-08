package CyberPunkReas.CovidSimulator.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Business {
	@Id
	@GeneratedValue
	private Integer id;
	private boolean essential;
	
	@OneToMany
	private List<Person> workers;
	
	@ManyToOne
	private Area area;
	
	public Business(Integer id, boolean essential, Area area)
	{
		this.id = id;
		this.essential = essential;
		this.area = area;
	}

	public Business() {

	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public List<Person> getWorkers() {
		return workers;
	}

	public void setWorkers(List<Person> workers) {
		this.workers = workers;
	}

	public void addWorker(Person person) {
		workers.add(person);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isEssential() {
		return essential;
	}

	public void setEssential(boolean essential) {
		this.essential = essential;
	}
}
