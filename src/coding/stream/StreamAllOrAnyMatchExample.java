package coding.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import coding.repo.Person;
import coding.repo.PersonRepository;

public class StreamAllOrAnyMatchExample {

	static Predicate<String> lengthCheckPredicate = num -> num.length() >= 9 ;
	static Predicate<Person> personHighCheck = per -> per.getHeight() >= 140; 
	static Predicate<Person> personGenderPredicate = per -> per.getGender().equals("M");
	public static void main(String[] args) {
	
		List<String> fruits = Arrays.asList("Apple","Orange","Graphs","Banana","Pineapple");
		Boolean lenghtResponse = fruits.stream().allMatch(lengthCheckPredicate);
		Boolean anyMatchResponse = fruits.stream().anyMatch(lengthCheckPredicate);
		Boolean personHightCheck = PersonRepository.getAllPerson().stream().allMatch(personHighCheck);
		Boolean personHightAnyMatchCheck = PersonRepository.getAllPerson().stream().anyMatch(personHighCheck);
		Boolean personHightAllMatchAnd = PersonRepository.getAllPerson().stream().allMatch(personHighCheck.and(personGenderPredicate));
		System.out.println("Lenght Test Pass All Matches:" + lenghtResponse);
		System.out.println("Lenght Test Pass Any Matches:" + anyMatchResponse);
		System.out.println("Person hight check all Matches : "+personHightCheck);
		System.out.println("Person hight check Any Matches : "+personHightAnyMatchCheck);
		System.out.println(personHightAllMatchAnd);
	}
}
