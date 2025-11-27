package coding.terminalOperation;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.*;

import java.util.HashMap;
import java.util.stream.Stream;

import coding.repo.Person;
import coding.repo.PersonRepository;

public class StreamGroupByExamples {

	static void groupByWithGender() {
		Map<String, List<Person>> groupByData = PersonRepository.getAllPerson().stream()
				.collect(Collectors.groupingBy(Person::getGender));
//	    groupByData.entrySet().forEach(per -> System.out.println("Key :" +per.getKey() + " Value" +per.getValue()));

		Stream.of(groupByData).forEach(System.out::println);
	}

	static void groupByHeight() {
		Map<String, List<Person>> groupByData = PersonRepository.getAllPerson().stream()
				.collect(Collectors.groupingBy(per -> per.getHeight() >= 165 ? "Tallest" : "shortes"));
		Stream.of(groupByData).forEach(System.out::println);
	}

	static void twoLevelGrouping() {
		Map<String, Map<String, List<Person>>> groupByData = PersonRepository.getAllPerson().stream().collect(Collectors
				.groupingBy(Person::getGender, groupingBy(per -> per.getHeight() >= 165 ? "Tallest" : "shortes")));
		Stream.of(groupByData).forEach(System.out::println);
	}

	static void twoLevelGroupingCount() {
		Map<String, Integer> groupByData = PersonRepository.getAllPerson().stream()
				.collect(Collectors.groupingBy(Person::getName, summingInt(per -> per.getKids())));
		Stream.of(groupByData).forEach(System.out::println);
	}

	static void threeLevelGrouping() {
	Map<String, List<Person>> groupByData	= PersonRepository.getAllPerson().stream()
		.collect(Collectors.groupingBy(Person :: getName, HashMap :: new, Collectors.toList()));
	Stream.of(groupByData).forEach(System.out::println);
	}
	public static void main(String[] args) {
//		groupByWithGender();
//		groupByHeight();
//		twoLevelGrouping();
//		twoLevelGroupingCount();
		threeLevelGrouping();
	}

}
