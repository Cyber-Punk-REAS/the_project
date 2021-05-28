import java.lang.reflect.Parameter;
import java.util.LinkedList;
import java.util.List;

/**
 * @Result.java
 */

public class Result
{
    int nDays;
    Region region;
    ParameterProfile pf;
    List<Integer> listDays = new LinkedList<>();

    public Result(){

    }

    public Region getRegion() {
        return region;
    }

    public List<Integer> getListDays() {
        return listDays;
    }

    public int getnDays() {
        return nDays;
    }

    public int getInfectedPersons(int day){
        return listDays.get(day);
    }


}
