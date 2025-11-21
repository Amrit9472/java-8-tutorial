package coding.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamLimitExamples {

	public static void main(String[] args) {

		List<String> fruits = Arrays.asList("Apple", "Oranges", "Water melone", "Pinaaple", "Banana", "Grapes");

		fruits.stream().limit(3).forEach(System.out::println);
		System.out.println("================================");
		fruits.stream().limit(3).collect(Collectors.toList()).forEach(System.out::println);
        
		
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
		int sum = numbers.stream().limit(3).reduce(0,(a,b) -> (a+b));
		System.out.println("Sum of number :"+sum);
		
		int skip = numbers.stream().skip(3).reduce(0, (a,b) -> (a+b));
		System.out.println("SKip  number Sum :"+skip);
	}

}
