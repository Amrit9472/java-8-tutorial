package coding.terminalOperation;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import coding.repo.Person;
import coding.repo.PersonRepository;

public class StreamJoiningExamples {

	static String joiningExample() {
		String s = PersonRepository.getAllPerson().stream().map(Person :: getName).collect(Collectors.joining());
		return s;
	}
	static String joiningWithDelimiterExample() {
		String s = PersonRepository.getAllPerson().stream().map(Person :: getName).collect(Collectors.joining("-","[","]"));
		return s;
	}
	public static void main(String[] args) {

		char[] ch = {'a','b','c','d','e'};
		String join = Stream.of(ch).map(arr -> new String(arr)).collect(Collectors.joining());
		System.out.println("joined data :" +join);
		
		System.out.println("Person Name without delimiter: "+joiningExample());
		
		System.out.println("Person Name with delimiter: "+joiningWithDelimiterExample());
	}

}
