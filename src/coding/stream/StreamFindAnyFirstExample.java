package coding.stream;

import java.util.Optional;
import java.util.function.Predicate;

import coding.repo.Person;
import coding.repo.PersonRepository;

public class StreamFindAnyFirstExample {

	static Predicate<String> lengthCheckPredicate = num -> num.length() >= 9;
	static Predicate<Person> personHighCheck = per -> per.getHeight() >= 200;
	static Predicate<Person> personGenderPredicate = per -> per.getGender().equals("M");

	public static void main(String[] args) {
        Optional<Person> findAny = findAnyMatch();
        if(findAny.isPresent())
		System.out.println("Find Any Result : " + findAny.get());
        
        Optional<Person> findFirst = findFirst();
        if(findFirst.isPresent())
		System.out.println("Find First Result : " + findFirst.get());

	}

	static Optional<Person> findAnyMatch() {
		return PersonRepository.getAllPerson().stream().filter(personHighCheck).findAny();
	}

	static Optional<Person> findFirst(){
		return PersonRepository.getAllPerson().stream().filter(personHighCheck.and(personGenderPredicate)).findFirst();
	}
}
