package testing;

import java.util.Random;

public class Population {
	
	private Person[] people; //inicializar
    private Random random = new Random();

    public Person getRandomPerson(){
        return this.people[random.nextInt(people.length)];
    }

}
