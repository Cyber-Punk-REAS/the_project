package CyberPunkReas.CovidSimulator.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Region {

    @Id
    @GeneratedValue
    
	private ArrayList<Area> areas;
	
	private String name;
	
	private int areasNumber;
	
	public Region(String name, int areasNumber) {
		this.name = name;
		this.areasNumber = areasNumber;
	}
	
	public void setRegionName( String name )
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

	public String getRegionName(){
		return name;
	}

	public int getAreasNumber(){
		return areasNumber;
	}

	public Area getAreabyIndex(int i){
		return areas.get(i);
	}

	public List<Area> getAreasList(){
		return areas;
	}
	

}
