package coding.consumer;

import java.util.function.Function;

public class FunctionalExample {

	
	static Function<String, String> f1 = name -> name.toUpperCase();
	static Function<String, String> f2 = name -> name.toUpperCase().concat(" Features");
	
	public static void main(String[] args) {
		System.out.println("Result to chnage the String to upper case :" + f1.apply("Java"));
		System.out.println("Result to chnage the String to upper case and concate the String :" + f2.apply("Java"));
		System.out.println("==================================================================");
		
		System.out.println("Result one :" +f1.andThen(f2).apply("Java"));
		System.out.println("Result two :" +f1.compose(f2).apply("java"));


	}
}
