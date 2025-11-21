package coding.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import coding.repo.Person;
import coding.repo.PersonRepository;

public class StreamFilterExample {

	static Predicate<Person> personHightPredicate = (p) -> p.getHeight() >= 166;
	static Predicate<Person> personGenderPredicate = (p) -> p.getGender().equals("M");

	public static void main(String[] args) {

		List<String> names = Arrays.asList("A", "bb", "sam", "Raj", "Grace Taylor", "Alice johnson", "Emma wilson");

		Stream<String> allNames = names.stream();

		Stream<String> updateListName = allNames.filter(p -> p.length() >= 2);

		updateListName.forEach(System.out::println);
		System.out.println("==========================");

		names.stream().filter(p -> p.length() >= 2).collect(Collectors.toList()).forEach(System.out::println);
		System.out.println("==========================");

		PersonRepository.getAllPerson().stream()
//		                .filter(p -> p.getHeight() >= 166)
//		                .filter(p -> p.getGender().equals("M"))
				.filter(personHightPredicate.and(personGenderPredicate)).collect(Collectors.toList())
				.forEach(System.out::println);
		/**
		 * List<Person> l1 = PersonRepository.getAllPerson() .stream() .filter(p ->
		 * p.getHeight() >= 166) .filter(p -> p.getGender().equals("M"))
		 * .collect(Collectors.toList()); l1.forEach(System.out::println);
		 */
	}

}
