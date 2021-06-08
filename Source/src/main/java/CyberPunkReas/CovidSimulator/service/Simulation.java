package CyberPunkReas.CovidSimulator.service;

import CyberPunkReas.CovidSimulator.models.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class Simulation {
    private static Random rnd = new Random();

    //OTHER METHODS
    public Result run(ParameterProfile params, Region region) {
        List<Integer> infectedPerDay = new ArrayList<>();
        List<Integer> deadPerDay = new ArrayList<>();

        for (Area a: region.getAreas()) {
            a.setBusinesses();
            a.setPopulation(params);
        }

        // Execution days of the simulation
        for (int i = 0; i < params.getExecutionTime(); i++) {
            int infected = 0;
            int dead = 0;
            for (Area area : region.getAreas()) {
                // Initialize population and business

                // Person spread loop
                for (Person person : area.getPopulation()) {
                    // Friends spread section
                    if (person.getContagiousness() > 0 && person.getFriends().size() > 0) {
                        List<Person> peopleCouldMeetToday = person.getPeopleCouldMeet();
                        if (peopleCouldMeetToday.size() > 0) {
                            int maxPeopleMetToday = peopleCouldMeetToday.size();
                            int peopleMetToday = rnd.nextInt(maxPeopleMetToday);
                            for (int j = 0; j < peopleMetToday; j++) {
                                /* Select a random friend from the whole list of peopleCouldMeetToday
                                 * i + rnd.nextInt(maxPeopleMetToday - peopleMetToday):
                                 * This allows to take any random friend from peopleCouldMeetToday
                                 * regardless of the size of peopleMetToday */
                                Person friendInQuestion = peopleCouldMeetToday.get(j + rnd.nextInt(maxPeopleMetToday - peopleMetToday));
                                if (friendInQuestion.isAlive() && rnd.nextInt(100) < person.getContagiousness() && friendInQuestion.getContagiousness() == 0 && !friendInQuestion.isImmunity()) {
                                    friendInQuestion.setContagiousness(params);
                                    System.out.println(person.getId() + " >F> " + friendInQuestion.getId()); //TODO, show in web interface NOT MANDATORY FOR DEMO
                                }
                            }
                        }
                    }
                    // Work spread section
                    // FIXME "!person.getBusiness().getArea().getRestrictionPolicy().isBusinessEssentialClosed()" may be replaceable by "!area.getRestrictionPolicy().isBusinessEssentialClosed()"
                    if (person.getContagiousness() > 0 && person.isEmployed() && (!person.getBusiness().getArea().getRestrictionPolicy().isBusinessEssentialClosed()
                            || (!person.getBusiness().isEssential() && !person.getBusiness().getArea().getRestrictionPolicy().isBusinessNonEssentialClosed()))) {
                        Business business = person.getBusiness();
                        ArrayList<Person> coworkers = (ArrayList<Person>) business.getWorkers();
                        coworkers.remove(person); // FIXME this may not work because hashCode and equals not redefined
                        if (coworkers.size() > 1) {
                            int maxCoworkersMetToday = coworkers.size();
                            // CoworkersMetToday = A fraction of the maximum proportional to the timeRestriction
                            int coworkersMetToday = maxCoworkersMetToday * (1 - business.getArea().getRestrictionPolicy().getTimeRestriction() / 10);
                            for (int j = 0; j < coworkersMetToday; j++) {
                                Person coworkerInQuestion = coworkers.get(j + rnd.nextInt(maxCoworkersMetToday - coworkersMetToday));
                                if (coworkerInQuestion.isAlive() && rnd.nextInt(100) < person.getContagiousness() && coworkerInQuestion.getContagiousness() == 0 && !coworkerInQuestion.isImmunity()) {
                                    coworkerInQuestion.setContagiousness(params);
                                    System.out.println(person.getId() + " >W> " + coworkerInQuestion.getId()); //TODO, show in web interface NOT MANDATORY FOR DEMO
                                }
                            }
                        }
                    }
                }
                // Increment days contagious & get amount of infected people
                for (Person person : area.getPopulation()) {
                    if (person.getContagiousness() > 0) {
                        if (person.getContagiousDays() == 0) {
                            infected++;
                        }

                        person.incrementContagiousDays();
                        if (person.getContagiousDays() > person.getMaxContagiousDays()) {
                            if (rnd.nextDouble() * 100 < person.getMortalityChance()) {
                                person.died();
                                dead++;
                                System.out.println("xxx" + person.getId() + "xxx"); //TODO, show in web interface NOT MANDATORY FOR DEMO
                            } else {
                                person.survived();
                                System.out.println("|||" + person.getId() + "|||"); //TODO, show in web interface NOT MANDATORY FOR DEMO
                            }
                        }
                    }
                }
            }
            infectedPerDay.add(infected);
            deadPerDay.add(dead);
        }

        //IT RETURNS A LIST OF INFECTED PEOPLE PER DAY
        return new Result(infectedPerDay, deadPerDay);
    }

    public ParameterProfile getDefaultParameterProfile() {
        ParameterProfile p = new ParameterProfile();
        p.setAverageContagiousness(80);
        p.setAverageFriends(15);
        p.setAverageContagiousDays(15);
        p.setExecutionTime(10);
        p.setImmunityChance(1);
        p.setInitialInfectedPeople(10);
        p.setUnemployment(10);
        return p;
    }

    public Region getDefaultRegion(int areas) {
        Region region = new Region();
        region.setName("Spain");
        region.setAreasNumber(areas);
        for (int i = 0; i < areas; i ++) {
            Area a = new Area();
            a.setName("Area " + i);
            a.setSize(1000);
            a.setPopulationSize(1000);
            a.setNumberOfBusiness(10);
            var rp = new Restriction();
            rp.setCurfew(i % 2 == 0);
            rp.setMobility(false);
            rp.setBusinessClosed(true, true);
            rp.setTimeRestriction(8);
            a.setRestrictionPolicy(rp);
            region.addArea(a);
        }
        return region;
    }
}
