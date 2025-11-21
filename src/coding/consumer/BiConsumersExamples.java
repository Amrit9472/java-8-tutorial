package coding.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumersExamples {

	public static void main(String[] args) {
		BiConsumer<Integer, Integer> con1 = (a, b) -> System.out.println("A + B :" + (a + b));
		con1.accept(2, 5);
		System.out.println("--------------------------------------------------");
		List<Integer> list1 = Arrays.asList(new Integer(10), new Integer(20), new Integer(30));
		List<Integer> list2 = Arrays.asList(new Integer(10), new Integer(20), new Integer(20));

		BiConsumer<List<Integer>, List<Integer>> cons1 = (l1, l2) -> {
			if (l1.size() == l2.size())
				System.out.println("TRUE");
			else
				System.out.println("False");
		};
		cons1.accept(list1, list2);
		System.out.println("--------------------------------------------------");
		BiConsumer<Integer, Integer> addConsumer = (a, b) -> System.out.println("A + B :" + (a + b));
		BiConsumer<Integer, Integer> subConsumer = (a, b) -> System.out.println("A - B :" + (a - b));
		BiConsumer<Integer, Integer> mulConsumer = (a, b) -> System.out.println("A * B :" + (a * b));

		addConsumer.accept(10, 20);
		subConsumer.accept(10, 20);
		mulConsumer.accept(10, 20);
		
		System.out.println("--------------------------------------------------");
		addConsumer.andThen(subConsumer).andThen(mulConsumer).accept(10, 20);

	}

}
