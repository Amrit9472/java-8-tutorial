package coding.consumer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

import coding.repo.Person;
import coding.repo.PersonRepository;

public class FunctionPersonExample {

	static Function<String, Integer>  f1 = name -> name.length();
	static Predicate<Person> p1 = (per) -> per.getHeight() >= 7;
	static Predicate<Person> p2 = (per) -> per.getGender().equals("M");
	
	static Function<List<Person>, Map<String, Double>> f2 = personList -> {
		Map<String, Double> map = new HashMap<String,Double>();
		personList.forEach(per -> {
			if(p1.and(p2).test(per))
			map.put(per.getName(), per.getSalary());
		});
		 return map;
	};
	
	static Function<List<Person>, Map<String , Integer>> personInformation = personList -> {
		Map<String, Integer> map = new HashMap();
		personList.forEach(person -> {
			if(person.getHeight() >= 6 && person.getGender().equals("F"))
			map.put(person.getName(), person.getKids());
		});
		return map;
	};
	public static void main(String[] args) {

		System.out.println("Result 1 :"+ f1.apply("Java features"));
		
		System.out.println("======================================");
		
		List<Person> personList = PersonRepository.getAllPerson();
		Map<String, Double> map = f2.apply(personList);
		System.out.println("Result 2 : " + map);
		
		System.out.println("======================================");
		Map<String, Integer> map2 = personInformation.apply(personList);
		System.out.println("Result 3 : " + map2);
	}

}
