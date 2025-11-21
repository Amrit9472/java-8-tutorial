package coding.consumer;

import java.util.List;
import java.util.function.BiConsumer;

import coding.repo.Person;
import coding.repo.PersonRepository;

public class BiConsumerPersonExamples {

	static void printPersonDetails() {
		BiConsumer<String, List<String>> personConsumer = (name, hobbies) -> System.out.println(name + " " + hobbies);
		BiConsumer<String, Double> salaryConsumer = (name, salary) -> System.out.println(name + " " + salary);

		List<Person> personList = PersonRepository.getAllPerson();
//		personList.forEach(p -> personConsumer.accept(p.getName(), p.getHobbies()));
		/*
		 * we can't use here andThen directly because the data Type of return type is
		 * different . if you want to use andThen then make sure both consumer data Type
		 * are same
		 */
//		personList.forEach(p -> personConsumer.andThen(salaryConsumer));
		personList.forEach(p -> {
			personConsumer.accept(p.getName(), p.getHobbies());
			salaryConsumer.accept(p.getName(), p.getSalary());
		});

	}

	public static void main(String[] args) {
		printPersonDetails();
	}
}
