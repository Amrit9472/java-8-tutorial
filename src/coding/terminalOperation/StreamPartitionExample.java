package coding.terminalOperation;

import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

import coding.repo.Person;
import coding.repo.PersonRepository;

public class StreamPartitionExample {

	static Predicate<Person> p1 = per -> per.getHeight() >= 170;

	static void byHeight() {
     Map<Boolean, List<Person>> map = PersonRepository.getAllPerson().stream().collect(partitioningBy(p1));
     System.out.println(map);
	}

	static void byHeightWith2Param() {
	     Map<Boolean, Set<Person>> map = PersonRepository.getAllPerson().stream().collect(partitioningBy(p1 ,Collectors.toSet()));
	     System.out.println(map);
		}
	static void byHeightWithMap() {
	     Map<Boolean, Map<String,List<String>>> map = PersonRepository.getAllPerson().stream()
	    		 .collect(partitioningBy(p1 ,Collectors.toMap(Person :: getName, Person :: getHobbies)));
	     System.out.println(map);
		}
	public static void main(String[] args) {

//		byHeight();
//		byHeightWith2Param();
		byHeightWithMap();
	}

}
