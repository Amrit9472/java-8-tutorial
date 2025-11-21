package coding.java8;

@FunctionalInterface
public interface TestFunctionalInterface {

	/*
	 * This is a abstract method
	 * Abstract method define as the method don't have body the implemented class 
	 * Subclasses must override and implement them
	 * Can’t be private, final, or static (in classes) 
	 */
	public abstract void add();

	default String defaultMethod() {
	  return "i am a default method";	
	}
	
	static void staticMethod() {
		
	}
}
