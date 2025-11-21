package coding.repo;

import java.util.Arrays;
import java.util.List;

public class PersonRepository {

	public static List<Person> getAllPerson() {

		Person p1 = new Person("Alice Johnson", 165, 52000.50, "F", 2,
				Arrays.asList("Reading", "Yoga", "Traveling", "Cooking"));
		Person p2 = new Person("Brian Smith", 178, 61000.75, "M", 1,
				Arrays.asList("Cycling", "Gaming", "Photography", "Hiking"));
		Person p3 = new Person("Catherine Lee", 160, 58000.00, "F", 0,
				Arrays.asList("Painting", "Dancing", "Running", "Gardening"));
		Person p4 = new Person("David Brown", 182, 72000.20, "M", 3,
				Arrays.asList("Fishing", "Woodworking", "Cooking", "Golf"));
		Person p5 = new Person("Emma Wilson", 170, 68000.90, "F", 2,
				Arrays.asList("Traveling", "Blogging", "Photography", "Swimming"));
		Person p6 = new Person("Frank Miller", 175, 49000.30, "M", 0,
				Arrays.asList("Reading", "Movies", "Gaming", "Cooking"));
		Person p7 = new Person("Grace Taylor", 162, 56000.10, "F", 1,
				Arrays.asList("Yoga", "Painting", "Music", "Traveling"));
		Person p8 = new Person("Grace Taylor", 182, 56000.10, "F", 1,
				Arrays.asList("Yoga", "Painting", "Music", "Traveling"));

		return Arrays.asList(p1, p2, p3, p4, p5, p6, p7,p8);
	}

	public static Person getPerson() {
		return new Person("Test 1", 5, 5.2, "M", 0, Arrays.asList("A hobbies", "B hobbies", "C hobbies", "D hobbies"));
	}
}
