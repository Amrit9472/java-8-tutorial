package coding.stream;

import java.util.Optional;

import coding.repo.Person;
import coding.repo.PersonRepository;

public class StreamReduceExample1 {

	public static void main(String[] args) {
     combineNames();
     Optional<Person> tallestPerson = getTallestPerson();
     System.out.println("Tallest Person is :" +tallestPerson.get());
	}

	private static void combineNames() {
		String names = PersonRepository.getAllPerson()
		 .stream()
		 .map(Person :: getName)
		 .reduce("" , (a,b) -> a.concat(b));   
		 System.out.println("Name are :" +names);
	}

	private static Optional<Person> getTallestPerson() {
		return PersonRepository.getAllPerson()
			   .stream()
			   .reduce((a,b) -> a.getHeight() > b.getHeight() ? a:b);
				
				
				
	}
}
