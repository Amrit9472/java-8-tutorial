package coding.consumer;

import java.util.function.Predicate;

public class PredicateExamples {

	public static void main(String[] args) {

		Predicate<Integer> lessThen = (a) -> (a <= 50);
		Predicate<Integer> greaterThen = (a) -> (a >= 100);
		Predicate<Integer> equal = (a) -> (a == 0);

//		boolean result = lessThen.test(10);
//		System.out.println("Result :" +result);

		System.out.println("Less Then :" + lessThen.test(150));
		System.out.println("Greater Then :" + greaterThen.test(150));
		System.out.println("equal :" + equal.test(4));

		System.out.println("==================================");

		boolean result = lessThen.and(greaterThen).and(equal).test(150);
		boolean result2 = lessThen.or(greaterThen).test(150);
		boolean result3 = lessThen.or(greaterThen).negate().test(150);


		System.out.println("Result And condition :" + result);
		System.out.println("Result Or condition :" + result2);
		System.out.println("Result with negate condition :" + result3);


	}

}
