package com.example.FunctionsPassedAsValuesJava;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * 
 * @author 212604352
 * Demonstrates how you can abstract the list type and use type T instead of a concrete type 
 * like Developer in the FilterDevelopers example
 * 
 * We still will be passing functions as values to filter the abastract list
 */
public class FilterAnyCollection {
	
	public static void main(String[] args){
		List<Integer> numbersInput = new ArrayList<>();
		numbersInput.add(5);
		numbersInput.add(10);
		numbersInput.add(20);
		numbersInput.add(30);
		numbersInput.add(55);
		//filter Integer list
		List<Integer> numbersOutput =filter(numbersInput, (Integer i)->i>20);
		
		List<String> stringInput = new ArrayList<>();
		stringInput.add("a");
		stringInput.add("b");
		stringInput.add("c");
		stringInput.add("d");
		stringInput.add("d");
		List<String> stringOutput = filter(stringInput, (String s) -> s.equals("a"));
		
		
	}
	
	
	public static <T> List<T> filter(List<T> itterateOverMe, Predicate<T> applyThisFilteringBehavior){
		List<T> result = new ArrayList<>();
		for (T t : itterateOverMe) {
			if(applyThisFilteringBehavior.test(t)){
				result.add(t);
			}
		}
		return result;
		
	}

}
