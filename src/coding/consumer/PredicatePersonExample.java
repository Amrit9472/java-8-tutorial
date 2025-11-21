package coding.consumer;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import coding.repo.Person;
import coding.repo.PersonRepository;

public class PredicatePersonExample {
    
	static Predicate<Person> p1 = (per) -> per.getHeight() >= 7;
	static Predicate<Person> p2 = (per) -> per.getGender().equals("M");
	
	
	
	public static void main(String[] args) {
		
		List<Person> personList = PersonRepository.getAllPerson();
		
		personList.stream()
		          .filter(p1)
		          .collect(Collectors.toList());
		personList.forEach(per -> {
			if(p1.and(p2).test(per)) {
				System.out.println(per);
			}
			
		});
		

	}

}
