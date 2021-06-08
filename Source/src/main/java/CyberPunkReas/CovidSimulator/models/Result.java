package CyberPunkReas.CovidSimulator.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Result
{
    @Id
    @GeneratedValue
    private int id;
    private int nDays;

    // TODO: add parameter profile
    // private ParameterProfile pf;

    // can't save a list in a single field
    private String daysDeaths;

    public Result() {

    }

    public int getnDays() {
        return nDays;
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

    public void setDaysDeaths(List<Integer> deaths) {
        String d = "";
        for(int i : deaths) {
            d.concat(String.valueOf(i));
        }
        this.daysDeaths = d;
    }
}