package coding.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import coding.repo.Person;
import coding.repo.PersonRepository;

public class StreamFlatMapExample {
	
	
	static List<String> hobbies(List<Person> personsList){
		return personsList.stream()
				.map(Person :: getHobbies)
				.flatMap(List :: stream)
				.sorted()
				.collect(Collectors.toList());
	}
	static List<String> hobbiesWithoutDupplicates(List<Person> personsList){
		return personsList.stream()
				.map(Person :: getHobbies)
				.flatMap(List :: stream)
				.sorted()
				.distinct()
				.collect(Collectors.toList());
	}
	static Set<String> hobbiesSet(List<Person> personsList){
		return personsList.stream()
				.map(Person :: getHobbies)
				.flatMap(List :: stream)
				.collect(Collectors.toSet());
	}

	static long hobbiesCount(List<Person> persList) {
		return persList.stream()
			   .map(Person :: getHobbies)
			   .flatMap(List :: stream)
			   .distinct()
			   .count();
	}
	public static void main(String[] args) {
      
		List<Integer> evenNumber = Arrays.asList(2,4,6,8,10);
		List<Integer> oddNumber = Arrays.asList(3,5,7,9,11);
		
		List<List<Integer>> listofList =  Arrays.asList(evenNumber,oddNumber);
		
		System.out.println("Befor flattern Map list" +listofList);
		
		List<Integer> flatternMapList = listofList.stream()
										.flatMap(list -> list.stream())
										.collect(Collectors.toList());
		System.out.println("After flattern Map list" +flatternMapList);
		System.out.println("person hobbies list" +hobbies(PersonRepository.getAllPerson()));
		System.out.println("person Without Dupplicates hobbies list" +hobbiesWithoutDupplicates(PersonRepository.getAllPerson()));
		System.out.println("person hobbies list with set" +hobbiesSet(PersonRepository.getAllPerson()));
		System.out.println("distinct hobbies count " +hobbiesCount(PersonRepository.getAllPerson()));
		
	}

}
