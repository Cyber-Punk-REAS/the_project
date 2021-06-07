package CyberPunkReas.CovidSimulator.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Region {

    @Id
    @GeneratedValue
	private int id;

    @OneToMany
	private List<Area> areas = new ArrayList<>();
	
	private String name;
	
	private int areasNumber;

	public Region() {

	}

	public void setName(String name )
	{
		this.name = name;
	}
	
	public void setAreasNumber( int areasNumber )
	{
		this.areasNumber = areasNumber;
	}
	
	public void addArea(Area area) {
		areas.add(area);
	}

	public String getName(){
		return name;
	}

	public int getAreasNumber(){
		return areasNumber;
	}

	public Area getAreaByIndex(int i){
		return areas.get(i);
	}

	public List<Area> getAreas(){
		return areas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
