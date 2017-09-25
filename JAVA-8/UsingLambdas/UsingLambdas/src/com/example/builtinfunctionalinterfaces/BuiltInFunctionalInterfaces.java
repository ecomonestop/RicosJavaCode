package com.example.builtinfunctionalinterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * ]
 * 
 * @author
 * 
 * 		This class will be used as the main. Overall, I will show the use of
 *         some of the built in functional interfaces: Predicate<T>,
 *         Consumer<T>, and Function<T,R>
 *
 */
public class BuiltInFunctionalInterfaces {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		// Predicate functional interface built into Java 8.
		// Use Predicate when you need to represent a boolean expression that
		// uses an object of type T
		List<Integer> numbersGrT3 = filter(numbers, (Integer i) -> i > 3);

		// Consumer functional interface being used.
		// use Consumer functional interface when you need to access an object
		// of type T and perform some operations on it.
		// In this case I just print out all the numbers
		forEach(numbers, (Integer i) -> System.out.println(i));

		// Function functional itnerface being used.
		// use this interface when you need to define a lambda that maps
		// information from an input object to an output
		List<String> numbersAsStrings = map(numbers, (Integer i) -> i.toString());

	}

	/**
	 * 
	 * @param myList
	 *            generic list of type T
	 * @param funct
	 *            - Function functional interface provided by java 8
	 * @return List<R> which represents the mapping from T to R, which the
	 *         Function interface does
	 * 
	 */
	public static <T, R> List<R> map(List<T> myList, Function<T, R> funct) {
		List<R> result = new ArrayList<>();
		for (T t : myList) {
			result.add(funct.apply(t));
		}
		return result;
	}

	/**
	 * 
	 * @param myList
	 *            generic list of type t
	 * @param con
	 *            - Consumer functional interface provided by java 8
	 * 
	 *            loops thru list type T and applies behavior implemented in the
	 *            abstract method accept and returns nothing. In our case,
	 *            accept currently is implemented to print each element in the
	 *            myList
	 */
	public static <T> void forEach(List<T> myList, Consumer<T> con) {
		for (T t : myList) {
			con.accept(t);
		}
	}

	/**
	 * 
	 * @param myList
	 *            - generic list that gets filtered based on predicate
	 * @param boolExpres
	 *            - Predicate
	 * @return - filtered list
	 * 
	 *         An example of using a Predicate functional Interface from Java 8
	 * 
	 */
	public static <T> List<T> filter(List<T> myList, Predicate<T> boolExpres) {
		List<T> newList = new ArrayList<>();
		for (T t : myList) {
			if (boolExpres.test(t)) {
				newList.add(t);
			}
		}
		return newList;
	}

}
