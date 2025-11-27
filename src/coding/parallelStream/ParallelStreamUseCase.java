package coding.parallelStream;

import java.util.List;
import java.util.stream.Collectors;

import coding.repo.Person;
import coding.repo.PersonRepository;

public class ParallelStreamUseCase {

	
	public static void main(String[] args) {
    System.out.println(getHobbiesBySeq());
    System.out.println(getHobbiesByParallel());
	}

	static List<String> getHobbiesBySeq(){
		long start = System.currentTimeMillis();
		List<String> hobbies =PersonRepository.getAllPerson()
				.stream()
				.map(Person :: getHobbies)
				.flatMap(List :: stream)
				.collect(Collectors.toList());
		long end = System.currentTimeMillis();
		System.out.println("Seq Duration :" +(end-start));
		return  hobbies;
	}
	
	static List<String> getHobbiesByParallel(){
		long start = System.currentTimeMillis();
		List<String> hobbies =PersonRepository.getAllPerson()
				.parallelStream()
				.map(Person :: getHobbies)
				.flatMap(List :: stream)
				.collect(Collectors.toList());
		long end = System.currentTimeMillis();
		System.out.println("Parallel Duration :" +(end-start));
		return  hobbies;
	}
}
