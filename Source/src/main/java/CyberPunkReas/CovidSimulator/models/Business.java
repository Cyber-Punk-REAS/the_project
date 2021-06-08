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
	
	public boolean isEsential() {
		return essential;
	}

	public Region getArea() {
		return area;
	}

	public Integer getId()
	{
		return this.id;
	}
	
	public boolean getType() 
	{
		return essential;
	}
	
	public void setId(Integer id)
	{
		this.id = id;
	}

	public void setType(boolean isEsential) 
	{
		this.essential = isEsential;
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

	public void setArea(Area area) {
		this.area = area;
	}
	
}
