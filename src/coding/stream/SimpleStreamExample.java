package coding.stream;

import java.time.Period;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import coding.repo.Person;
import coding.repo.PersonRepository;

public class SimpleStreamExample {

	public static void main(String[] args) {

		Stream<Integer> s1 = Stream.of(1, 2, 3, 4, 5, 6);
		s1.forEach(p -> System.out.println(p));

		System.out.println("==================");

		Stream<Integer> s2 = Stream.of(new Integer[] { 0, 1, 2, 3, 4, 5, 6 });
		s2.forEach(p -> System.out.println(p));

		System.out.println("==================");

		Predicate<Person> heightPredicate = (per) -> per.getHeight() >= 170;
		Predicate<Person> genderPredicate = (per) -> per.getGender().equals("M");

		Map<String, List<String>> personMap = PersonRepository.getAllPerson() // iterate all persons
				.stream() // Stream of Person
				.filter(heightPredicate)
				.filter(genderPredicate)
				.collect(Collectors.toMap(Person::getName, Person::getHobbies));

		System.out.println("Person Map : " + personMap);

		List<List<String>> personHobbiesList = PersonRepository
				.getAllPerson()
				.stream()
				.map(Person::getHobbies)
				.distinct()
				.collect(Collectors.toList());

		System.out.println("Person Map Hobbies List : " + personHobbiesList);
		List<String> personHobbies = PersonRepository
				.getAllPerson()
				.stream()
				.map(Person::getHobbies)
				.flatMap(List::stream)
				.distinct().collect(Collectors.toList());

		System.out.println("Person Map Hobbies List : " + personHobbies);
		
		List<String> personNameAndGender = PersonRepository
				.getAllPerson()
				.stream()
				 .map(person -> person.getName() + " - " + person.getGender())
				.distinct().collect(Collectors.toList());

		System.out.println("Person Name and Gender List : " + personNameAndGender);

	}

}
