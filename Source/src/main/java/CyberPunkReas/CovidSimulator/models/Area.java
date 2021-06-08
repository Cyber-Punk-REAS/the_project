package CyberPunkReas.CovidSimulator.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Area {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @OneToOne
    private Restriction restrictionPolicy;
    @OneToMany()
    private List<Business> businesses;
    @OneToMany
    private List<Person> population;


    public Area(Restriction restrictionPolicy, String name) {
        this.name = name;
        setRestrictionPolicy(restrictionPolicy);
    }

    public Area() {
    }

    public List<Person> getPopulation() {
        return population;
    }

    public void setPopulation(List<Person> areaPopulation) {
        population = areaPopulation;
    }

    public Restriction getRestrictionPolicy() {
        return restrictionPolicy;
    }

    public void setRestrictionPolicy(Restriction restrictionPolicy) {
        this.restrictionPolicy = restrictionPolicy;
    }

    public List<Business> getBusinesses() {
        return businesses;
    }

    public void setBusinesses(List<Business> businesses) {
        this.businesses = businesses;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}