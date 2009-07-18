package common;

/**
 * Creates an abstract class for the Singleton design pattern.
 */
public class Singleton {
	static Singleton instance;
	
	protected Singleton() { }
	
	public static Singleton instance() {
		return (instance == null) ? new Singleton() : instance;
	}
}
