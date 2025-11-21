package coding.stream;

import java.util.function.Predicate;

import coding.repo.Person;
import coding.repo.PersonRepository;

public class StreamMapFilterReduceExample {

	static Predicate<Person> heightPredicate = (per) -> per.getHeight() > 160;
	static Predicate<Person> genderPredicate = (per) -> per.getGender().equals("M");

	public static void main(String[] args) {

		int kidsCount = PersonRepository.getAllPerson()
				.stream()
				.filter(heightPredicate.and(genderPredicate))
				.map(Person::getKids)			
//				.reduce(0, Integer::sum);
				.reduce(0, (a,b) -> (a+b));
		System.out.println("Number of kids :" + kidsCount);

	}

}
