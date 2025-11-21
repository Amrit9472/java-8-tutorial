package coding.stream;

import java.util.Comparator;

import coding.repo.Person;
import coding.repo.PersonRepository;

public class StreamCustomSortExample {

	public static void main(String[] args) {
		System.out.println("Sort By Name");
		PersonRepository.getAllPerson().stream().sorted(Comparator.comparing(Person::getName))
				.forEach(System.out::println);
	
		System.out.println("Sort By height");
		PersonRepository.getAllPerson().stream().sorted(Comparator.comparing(Person::getHeight))
				.forEach(System.out::println);
		
		System.out.println("Revers Sort By Name");
		PersonRepository.getAllPerson().stream().sorted(Comparator.comparing(Person::getName).reversed())
				.forEach(System.out::println);
		
		System.out.println("Revers Sort By height");
		PersonRepository.getAllPerson().stream().sorted(Comparator.comparing(Person::getHeight).reversed())
				.forEach(System.out::println);
	}
	

}
