package coding.terminalOperation;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

import coding.repo.Person;
import coding.repo.PersonRepository;

public class StreamMappingExample {

	static List<String> mappingExample() {
		List<String> names = PersonRepository.getAllPerson().stream().map(Person::getName).collect(Collectors.toList());
		
		List<String> names1 = PersonRepository.getAllPerson().stream().collect(mapping(Person :: getName,Collectors.toList()));
		return names1;
	}
	
	static Set<String> mappingExample1() {
		List<String> names = PersonRepository.getAllPerson().stream().map(Person::getName).collect(Collectors.toList());
		
		Set<String> names1 = PersonRepository.getAllPerson().stream().collect(mapping(Person :: getName,Collectors.toSet()));
		return names1;
	}

	static long countTallPersons() {
		return PersonRepository.getAllPerson().stream()
				.filter(per -> per.getHeight() >= 180)
				.collect(Collectors.counting());
	}
	public static void main(String[] args) {

		System.out.println(" Person Name List :" +mappingExample());
		mappingExample().forEach(System.out :: println);
		System.out.println("--------------------------");
		mappingExample1().forEach(System.out :: println);
		System.out.println("--------------------------");
		System.out.println(" Person Tallest count :" +countTallPersons());
	}

}
