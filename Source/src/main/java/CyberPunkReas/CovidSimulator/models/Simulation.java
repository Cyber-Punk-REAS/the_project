package CyberPunkReas.CovidSimulator.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Simulation {
	
	private ParameterProfile param;
	private Region region;
	private Random rnd = new Random();
	private int[] infectedPerDay;
	
	public Simulation(Region region, ParameterProfile param)
	{
		this.param = param;
		this.region = region;
		infectedPerDay = new int[param.getExecutionTime()];
	}
	
	//OTHER METHODS
	public void run()
	{
		
		for(Area area : region.getAreas()) {
			// Execution days of the simulation
			for(int i = 0; i < param.getExecutionTime(); i++) {
				infectedPerDay[i] = 0;
				// Person spread loop
				for(Person person : area.getPopulation()) {
					// Friends spread section
					if(person.getContagiousness() > 0 && person.getFriends().size()> 0) {
						List<Person> peopleCouldMeetToday = person.getPeopleCouldMeet();
						if(peopleCouldMeetToday.size() > 0) {
							int maxPeopleMetToday = peopleCouldMeetToday.size();
							int peopleMetToday = rnd.nextInt(maxPeopleMetToday);
							for(int j = 0; j < peopleMetToday; j++) {
								/* Select a random friend from the whole list of peopleCouldMeetToday
								 * i + rnd.nextInt(maxPeopleMetToday - peopleMetToday): 
								 * This allows to take any random friend from peopleCouldMeetToday
								 * regardless of the size of peopleMetToday */ 
								Person friendInQuestion = peopleCouldMeetToday.get(j + rnd.nextInt(maxPeopleMetToday - peopleMetToday));
								if(rnd.nextInt(100) < person.getContagiousness() && friendInQuestion.getContagiousness() == 0 && !friendInQuestion.isImmunity()) {
									friendInQuestion.setContagiousness(param);
									System.out.println(person.getId()+" >F> "+friendInQuestion.getId()); //TODO, show in web interface NOT MANDATORY FOR DEMO
								}
							}
						}
					}
					// Work spread section
					if(person.getContagiousness() > 0 && person.isEmployed()) {
						Business business = person.getBusiness();
						ArrayList<Person> coworkers = (ArrayList<Person>) business.getWorkers();
						coworkers.remove(person); // FIXME this may not work because hashCode and equals not redefined
						if(coworkers.size() > 1) {
							int maxCoworkersMetToday = coworkers.size();
							// CoworkersMetToday = A fraction of the maximum proportional to the timeRestriction
							int coworkersMetToday = maxCoworkersMetToday * (1 - business.getArea().getRestrictionPolicy().getTimeRestriction()/10);
							for(int j = 0; j < coworkersMetToday; j++) {
								Person coworkerInQuestion = coworkers.get(j + rnd.nextInt(maxCoworkersMetToday - coworkersMetToday));
								if(rnd.nextInt(100) < person.getContagiousness() && coworkerInQuestion.getContagiousness() == 0 && !coworkerInQuestion.isImmunity()) {
									coworkerInQuestion.setContagiousness(param);
									System.out.println(person.getId()+" >W> "+coworkerInQuestion.getId()); //TODO, show in web interface NOT MANDATORY FOR DEMO
								}
							}
						}
					}
				}
				// Increment days contagious & get amount of infected people
				for(Person person : area.getPopulation()) {
					if(person.getContagiousness() > 0) {
						person.incrementContagiousDays();
						if(person.getContagiousDays() > person.getMaxContagiousDays()) {
							person.survived();
							System.out.println("|||"+person.getId()+"|||"); //TODO, show in web interface NOT MANDATORY FOR DEMO
						}
						infectedPerDay[i]++;
					}
				}
			}
			
		}
		
		//IT RETURNS A LIST OF INFECTED PEOPLE PER DAY
	}

	public ParameterProfile getParam() {
		return param;
	}

	public Region getRegion() {
		return region;
	}

	public void setParam(ParameterProfile param) {
		this.param = param;
	}

	public void setRegion(Region region) {
		this.region = region;
	}
}
