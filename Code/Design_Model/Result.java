import java.lang.reflect.Parameter;
import java.util.List;

import javax.swing.plaf.synth.Region;

/**
 * @Result.java
 */

public class Result
{
    int nDays;
    ParameterProfile pf;
    List<Region> listDays;

    public Result(int nDays,ParameterProfile pf, List<Region> listDays){
        if(nDays < 0 ) throw new IllegalArgumentException("The simulation duration must be 0 or more");
        if(listDays.size() != nDays ) throw new IllegalArgumentException("The list of days should be the same size as the total duration of the simulation");
        this.nDays = nDays;
        this.pf = pf;
        this.listDays = listDays;
    }

    public Region getRegion(int day) {
       if(day >= nDays || day < 0 ) throw new IllegalArgumentException("The simulation duration was of "+nDays+" ,wrong day was given");
       return listDays.get(day);
    }

    public List<Region> getListDays() {
        return listDays;
    }

    public int getnDays() {
        return nDays;
    }

    public int getInfectedPersons(int day){
        if(day >= nDays || day < 0 ) throw new IllegalArgumentException("The simulation duration was of "+nDays+" ,wrong day was given");
        int res = 0;
        for(Area a : listDays.get(day).getAreas()){
            res = res + Area.getPopulation().getInfected();
        }
        return res;
    }


}
