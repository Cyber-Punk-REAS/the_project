package CyberPunkReas.CovidSimulator.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Day {

    @Id
    @GeneratedValue
    private Map<Region, Integer> numInfected;
    private Map<Region, Integer> numDeaths;
    private Map<Region, Integer> totalPeople;
    private Map<Region, Integer> numImmune;

    public Day (Map<Region, Integer> NInf, Map<Region, Integer> ND, Map<Region, Integer> TP, Map<Region, Integer> NImm) {
        this.numInfected = NInf;
        this.numDeaths = ND;
        this.totalPeople = TP;
        this.numImmune = NImm;
    }

    public Day () {
        this.numInfected = new HashMap<>();
        this.numDeaths = new HashMap<>();
        this.totalPeople = new HashMap<>();
        this.numImmune = new HashMap<>();
    }

    public Map<Region, Integer> getNumInfected() { return this.numInfected; }

    public Map<Region, Integer> getNumDeaths() { return this.numDeaths; }

    public Map<Region, Integer> getTotalPeople() { return this.totalPeople; }

    public Map<Region, Integer> getNumImmune() { return this.numImmune; }

    public void setNumInfected(Map<Region, Integer> NI) { this.numInfected = NI; }

    public void setNumDeaths(Map<Region, Integer> ND) { this.numDeaths = ND; }

    public void setTotalPeople(Map<Region, Integer> TP) { this.totalPeople = TP; }

    public void setNumImmune(Map<Region, Integer> NI) { this.numImmune = NI; }


}
