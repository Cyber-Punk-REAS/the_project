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
    private int totalInfected=0;
    private int totalDeaths=0;

    // TODO: add parameter profile
    // private ParameterProfile pf;

    // can't save a list in a single field
    private String daysDeaths;
    private String daysInfected;

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

    public List<Integer> getDaysInfected() {
        List<Integer> d = new ArrayList<Integer>();
        int val= 0;

        for(String field : this.daysInfected.split(",")) {
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

    public void setDaysInfected(List<Integer> infected) {
        String d = "";
        for(int i : infected) {
            d.concat(String.valueOf(i));
        }
        this.daysInfected = d;
    }

    public void setTotalInfected() {
        int res=0;
        for(String field : this.daysInfected.split(",")) {
            try {
                res += Integer.parseInt(field);

            } 
            catch (NumberFormatException e) {
                e.printStackTrace();
            }
         }
    totalInfected = res;
    }

    public void setTotalDeaths() {
        int res=0;
        for(String field : this.daysDeaths.split(",")) {
            try {
                res += Integer.parseInt(field);

            } 
            catch (NumberFormatException e) {
                e.printStackTrace();
            }
         }
    totalDeaths = res;
    }

public void setTotalDeathsParameter(int deaths){
    totalDeaths=deaths;
}

public void setTotalInfectedParameter(int infected){
    totalInfected=infected;
}

}