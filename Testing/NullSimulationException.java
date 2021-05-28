package testing;

public class NullSimulationException extends RuntimeException {
	
	public NullSimulationException(String s)
	{
		super();
		System.out.println(s);
	}
}
