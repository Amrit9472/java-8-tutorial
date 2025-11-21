package coding.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java7Vs8 {

	public static void main(String[] args) {
		// java 7
		List<String> names = Arrays.asList("Amrit Raj", "Aadesh giri", "sahil sethigar", "Ankit Raj", "Ajit kumar");
		ArrayList<String> uniqueNames = new ArrayList<>();
		for (String name : names) {
			if (name.startsWith("A")) {
				uniqueNames.add(name);
			}
		}
		System.out.println("Java 7:" + uniqueNames);

		// java 8
		List<String> uniquesNamesJava8 = names.stream().filter(name -> name.startsWith("A"))
				.collect(Collectors.toList());
		System.out.println("Java 8:" + uniquesNamesJava8);

		// Example 2
		// Java 7
		List<String> duplicateNameList = Arrays.asList("Amrit Raj", "Amrit Raj", "Amrit Singh", "Sam", "Sam");
		List<String> removeDuplicateNameList = new ArrayList<>();

		for (int i = 0; i < duplicateNameList.size(); i++) {
			String name = duplicateNameList.get(i);
			if (!removeDuplicateNameList.contains(name))
				removeDuplicateNameList.add(name);
		}
		System.out.println("Without Duplicates with java 7 : " + removeDuplicateNameList);

		// Java 8
		List<String> removeDuplicateNameList2 = duplicateNameList.stream().distinct().collect(Collectors.toList());
		System.out.println("Without Duplicates with java 8: " + removeDuplicateNameList2);
	}
}
