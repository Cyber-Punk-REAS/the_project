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
    private ArrayList<Person> people;
    private ArrayList<Business> businesses;
    
    @OneToMany (mappedBy = "region")
    List<Person> population;

    public Region (ArrayList<Person> listPeople, ArrayList<Business> listBusinesses) {
        this.people = listPeople;
        this.businesses = listBusinesses;
    }

    public Region () {
        this.people = new ArrayList<>();
        this.businesses = new ArrayList<>();
    }

    public ArrayList<Person> getPeople() { return people; }

    public ArrayList<Business> getBusinesses() { return businesses; }

    public void addPerson(Person p) { this.people.add(p); }

    public void addBusiness(Business b) { this.businesses.add(b); }

    public void setPeople(ArrayList<Person> plist) { this.people = plist; }

    public void setBusinesses(ArrayList<Business> blist) { this.businesses = blist; }

    @Override
    public int hashCode() {
        int res = 0;
        for (Person p : people) {
            res += p.hashCode();
        }
        for(Business b : businesses) {
            res += b.hashCode();
        }
        return res;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Region other = (Region) obj;
        boolean res = true;
        for (Person p : people) {
            res = other.people.contains(p);
        }
        for(Business b : businesses) {
            res = other.businesses.contains(b);
        }
        return res;
    }

}
