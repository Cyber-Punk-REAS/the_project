package testing;

import java.util.LinkedList;
import java.util.List;

public class Results {
	
	int nDays;
    ParameterProfile pf;
    List<Integer> listDays = new LinkedList<>();

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
