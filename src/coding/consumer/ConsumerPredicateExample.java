package coding.consumer;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

import coding.repo.Person;
import coding.repo.PersonRepository;

public class ConsumerPredicateExample {

	static Predicate<Person> heightfilterPredicate = p -> p.getHeight() >= 5;
	static Predicate<Person> genderFilterPredicate = p -> p.getGender().equals("M");

	static BiPredicate<Integer, String> BiPredicateFiltesOnHightAndGender = (height, gender) -> height >= 5
			&& gender.equals("M");

	static BiConsumer<String, List<String>> personNameAndHobbiesConsumer = (name, hobbies) -> {
		System.out.println(name + " " + hobbies);
	};

	static Consumer<Person> personConsumer = per -> {
//		if (heightfilterPredicate.and(genderFilterPredicate).test(per))
		if (BiPredicateFiltesOnHightAndGender.test(per.getHeight(), per.getGender()))

		{
			personNameAndHobbiesConsumer.accept(per.getName(), per.getHobbies());
		}
	};

	public static void main(String[] args) {

		List<Person> personList = PersonRepository.getAllPerson();

		personList.forEach(personConsumer);
	}

}
