package coding.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import coding.repo.Person;
import coding.repo.PersonRepository;

public class StreamVsCollection {

	public static void main(String[] args) {

		List<String> names = new ArrayList<>();
		names.add("Alice Johnson");
		names.add("Brian Smith");
		names.add("David Brown");

		System.out.println("With collection for Each response");
		for (String name : names) {
			System.out.println("iteration 1 >>>>" + name);
		}

		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		for (String name : names) {
			System.out.println("iteration 2 >>>>" + name);
		}

		System.out.println("With Stream for Each method response");

		Stream<String> stream = names.stream();
		stream.forEach(p -> System.out.println("<<<< :" + p));

		/**
		 * we can so iteration more then once time on iteration using java 8 it will
		 * give us error Exception in thread "main" java.lang.IllegalStateException:
		 * stream has already been operated upon or closed stream.forEach(p ->
		 * System.out.println("<<<< :" + p));
		 */

		/**
		 * peek() is an intermediate operation in the Stream API. It is mainly used for
		 * debugging or inspecting the elements as they flow through the stream
		 * pipeline.
		 */

		List<String> personName = PersonRepository.getAllPerson()
													.stream()
													.peek(p -> System.out.println(p))
													.map(Person::getGender)
													.peek(p -> System.out.println(p))
													.collect(Collectors.toList());

	}

}
