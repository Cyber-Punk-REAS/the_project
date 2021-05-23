import java.util.Random;

public class Person{
    private static int _id_ = 0;
    private Random random = new Random();
    private int id;
    private Area area;
    private Population population;
    private boolean startingImmunity;
    private boolean alive;
    private boolean employed;
    private Business business;
    private double contagiousness;
    private Person[] friends;

    public Person(Area area, Population population){
        this.id = Person._id_++;
        this.area = area;
        this.population = population;
        this.startingImmunity = false;
        this.employed = false;
        this.alive = true;
    }

    public void setBusiness(Business business){
        if(employed)
            this.business = business;
        else
            this.business = null;
    }

    public void setStartingImmunity(ParameterProfile param){
        if(random.nextInt(100) < param.getStartingImmunityChance())
            startingImmunity = true;
    }

    public void setWork(ParameterProfile param){
        if(random.nextInt(100) > param.getUnemployment())
            employed = true;
    }

    public void setFriends(ParameterProfile param){
        for(int i = 0; i < Person.rndFriends(param); i++)
            friends[i] = population.getRandomPerson();
    }

    
    private static int rndFriends(ParameterProfile param){
        Random rnd = new Random();
        
        return (int) ((rnd.nextGaussian() + param.getAverageFriends()) * param.getFriendsStandardDeviation());
    }
    
    
}

public class ParameterProfile{

    private int startingImmunityChance;
    private double averageFriends;
    private int averageDaysContagious;
    private int daysForSimulation;
    private int unemployment;
    private Random random = new Random();

    public int getStartingImmunityChance() {
        return startingImmunityChance;
    }

    public int getUnemployment() {
        return unemployment;
    }

    public double getFriendsStandardDeviation() {
        return averageFriends / 3;
    }

    public double getAverageFriends() {
        return averageFriends;
    }

    public int getDaysContagious(){
        return (int) (random.nextGaussian() + this.averageDaysContagious) * 3;
    }
    
}


public class Population{

    private Person[] people;
    private Random random = new Random();

    public Person getRandomPerson(){
        return this.people[random.nextInt(people.length)];
    }
}


public class Area{

}