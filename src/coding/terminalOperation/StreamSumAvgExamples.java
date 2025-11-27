package coding.terminalOperation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import coding.repo.Person;
import coding.repo.PersonRepository;

public class StreamSumAvgExamples {

	static int totalNoOfKids() {
		return PersonRepository.getAllPerson()
				.stream()
				.filter(per -> per.getGender().equals("F"))
				.collect(Collectors.summingInt(Person :: getKids));
	}
	static Double avgrangeHeightOfPersons() {
		return PersonRepository.getAllPerson()
				.stream()
				.filter(per -> per.getGender().equals("F"))
				.collect(Collectors.averagingDouble(Person :: getHeight));
	}
	public static void main(String[] args) {

		System.out.println("total Kids :"+totalNoOfKids());
		System.out.println("Average Height :"+avgrangeHeightOfPersons());
	    List<Integer> intValues = Arrays.asList(1,2,3,4,5,6);
	    int total = intValues.stream().collect(Collectors.summingInt(Integer :: intValue));
	    System.out.println("total "+total);
	}

}
