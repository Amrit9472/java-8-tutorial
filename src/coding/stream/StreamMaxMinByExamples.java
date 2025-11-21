package coding.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import coding.repo.Person;
import coding.repo.PersonRepository;

public class StreamMaxMinByExamples {

	static Optional<Person> getTallestPerson(){
		return PersonRepository.getAllPerson()
			 .stream()
			 .collect(Collectors.maxBy(Comparator.comparing(Person :: getHeight)));
	}
	
	static Optional<Person> getShortPerson(){
		return PersonRepository.getAllPerson()
			 .stream()
			 .collect(Collectors.minBy(Comparator.comparing(Person :: getHeight)));
	}
	
	static List<Person> filterMultiplePersonsMaxHeight(){
		List<Person> personsList = new ArrayList<Person>();
		Optional<Person> maxHeight  = getTallestPerson();
		Person per = maxHeight.isPresent() ? maxHeight.get() : null;
		if(null != per) {
			personsList = PersonRepository.getAllPerson()
					.stream()
					.filter(person -> person.getHeight() == per.getHeight())
					.collect(Collectors.toList());
		}
		return personsList;
	}
	public static void main(String[] args) {

		System.out.println("Tallest Person :" + getTallestPerson().get());
		System.out.println("Short Person :" + getShortPerson().get());
		System.out.println("Group by Tallest Person :" + filterMultiplePersonsMaxHeight());
	}

}
