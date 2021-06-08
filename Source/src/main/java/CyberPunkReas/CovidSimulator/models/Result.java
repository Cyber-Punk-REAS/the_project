package CyberPunkReas.CovidSimulator.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

@Entity
public class Result
{
    @Id
    @GeneratedValue
    private int id;
    private int totalInfected;
    private int totalDeaths;

    // TODO: add parameter profile
    // private ParameterProfile pf;

    // can't save a list in a single field
    private String daysInfections;
    private String daysDeaths;

    public Result() {

    }

    public Result(List<Integer> daysInfections, List<Integer> daysDeaths) {
        setDaysInfections(daysInfections);
        setDaysDeaths(daysDeaths);
    }

    public List<Integer> getDaysDeaths() {
        List<Integer> d = new ArrayList<Integer>();
        int val= 0;

        for(String field : this.daysDeaths.split(",")) {
            try {
                val = Integer.parseInt(field);
            }
            // If the String contains other thing that digits and commas
            catch (NumberFormatException e) {
                e.printStackTrace();
            }
            d.add(val);
        }

        return d;
    }

    public int getTotalInfected() {
        return totalInfected;
    }

    public int getTotalDeaths() {
        return totalDeaths;
    }

    public void setDaysDeaths(List<Integer> deaths) {
        StringJoiner sj = new StringJoiner(",");
        for(int i : deaths) {
            sj.add(String.valueOf(i));
            totalDeaths += i;
        }
        this.daysDeaths = sj.toString();
    }

    public List<Integer> getDaysInfections() {
        List<Integer> d = new ArrayList<Integer>();
        int val= 0;

        for(String field : this.daysInfections.split(",")) {
            try {
                val = Integer.parseInt(field);
            }
            // If the String contains other thing that digits and commas
            catch (NumberFormatException e) {
                e.printStackTrace();
            }
            d.add(val);
        }

        return d;
    }

    public void setDaysInfections(List<Integer> infected) {
        StringJoiner sj = new StringJoiner(",");
        for(int i : infected) {
            sj.add(String.valueOf(i));
            totalInfected += i;
        }
        this.daysInfections = sj.toString();
    }

    public void setTotalDeaths(int deaths){
        totalDeaths=deaths;
    }

    public void setTotalInfected(int infected){
        totalInfected=infected;
    }
}