package coding.consumer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

import coding.repo.Person;
import coding.repo.PersonRepository;

public class BiFunctionExamples {

	static BiFunction<String, String, String> bf1 = (a, b) -> (a + " " + b);
	static Predicate<Person> p1 = per -> per.getHeight() >= 6;
	static Predicate<Person> p2 = per -> per.getGender().equals("F");

	static BiFunction<List<Person>, Predicate<Person>, Map<String, Double>> bf2 = (personList, predicate) -> {
		Map<String, Double> resultMap = new HashMap<>();
		personList.forEach(per -> {
			if (p1.test(per))
				resultMap.put(per.getName(), per.getSalary());
		});
		return resultMap;
	};

	public static void main(String[] args) {
		System.out.println("Result 1 :" + bf1.apply("Java", "features"));
		
		System.out.println("===========================================");
		
		List<Person> personList = PersonRepository.getAllPerson();
		Map<String, Double> map = bf2.apply(personList, p2);
		System.out.println("Result :" +map);
	}
}
