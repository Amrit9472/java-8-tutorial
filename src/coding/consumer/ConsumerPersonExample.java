package coding.consumer;

import java.util.List;
import java.util.function.Consumer;

import coding.repo.Person;
import coding.repo.PersonRepository;

public class ConsumerPersonExample {

	static Consumer<Person> p1 = (p) -> System.out.println(p);
	static Consumer<Person> p2 = (p) -> System.out.println(p.getName().toUpperCase());
	static Consumer<Person> p3 = (p) -> System.out.println(p.getHobbies());

	static List<Person> personList = PersonRepository.getAllPerson();

	static void printAllPerson() {
		personList.forEach(p1.andThen(p2));
	}

	static void printWithcondition() {
		personList.forEach(p -> {
			if (p.getGender().equals("M") && p.getHeight() >= 6) {
				p2.andThen(p3).accept(p);
			}
		});
	}

	public static void main(String[] args) {
		p1.accept(PersonRepository.getPerson());
		p2.accept(PersonRepository.getPerson());
		p3.accept(PersonRepository.getPerson());

		System.out.println("-------------In One line upper code output ----------------");

		p1.andThen(p2).andThen(p3).accept(PersonRepository.getPerson());

		System.out.println("-----------------------------");
		printAllPerson();

		System.out.println("-----------------------------");
		printWithcondition();

	}

}
