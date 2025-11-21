package coding.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import coding.repo.Person;
import coding.repo.PersonRepository;

public class StreamMapExamples {
	static List<String> toUpperTransform(List<Person> listOfPerson){
		return listOfPerson.stream()
			   .map(Person :: getName)
			   .map(String :: toUpperCase)
			   .collect(Collectors.toList());
	}
	static Set<String> toUpperTransformSet(List<Person> listOfPerson){
		return listOfPerson.stream()
			   .map(Person :: getName)
			   .map(String :: toUpperCase)
			   .collect(Collectors.toSet());
	}

	public static void main(String[] args) {

		List<String> fruits = Arrays.asList("Apple", "Orange", "Banana", "PineApple");

		List<Integer> fruitLenght = fruits.stream().map(String::length).collect(Collectors.toList());
		System.out.println("Length List :" + fruitLenght);
		System.out.println("Name to upper case " +toUpperTransform(PersonRepository.getAllPerson()));
		System.out.println("Name to upper case set Response " +toUpperTransformSet(PersonRepository.getAllPerson()));
	}

	

}
