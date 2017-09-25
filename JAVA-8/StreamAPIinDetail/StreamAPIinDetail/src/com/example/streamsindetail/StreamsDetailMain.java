package com.example.streamsindetail;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.summarizingInt;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class StreamsDetailMain {

	public static void main(String[] args) {
		List<Dish> menu = Arrays.asList(
			    new Dish("pork", false, 800, Dish.Type.MEAT),
			    new Dish("beef", false, 700, Dish.Type.MEAT),
			    new Dish("chicken", false, 400, Dish.Type.MEAT),
			    new Dish("french fries", true, 530, Dish.Type.OTHER),
			    new Dish("rice", true, 350, Dish.Type.OTHER),
			    new Dish("season fruit", true, 120, Dish.Type.OTHER),
			    new Dish("pizza", true, 550, Dish.Type.OTHER),
			    new Dish("prawns", false, 300, Dish.Type.FISH),
			    new Dish("salmon", false, 450, Dish.Type.FISH) );
		
		List<Dish> vegetarianMenu = getVegetarianMenu(menu);
		
		//even numbers using distinct.  Distinct needs you to implement hashcode and equals to work
		List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
		numbers.stream()
				.filter(i -> i % 2 == 0)
				.distinct() 
				.forEach(System.out::println);
		
		//using Limit
		List<Dish> first3DishesUnder300Cals = getFirst3Under300(menu);
		
		//using skip
		List<Dish> skipFirst2BringBackOthersUnder300Cal = skipFirst2BringBackOthersUnder300Cal(menu);
		
		//using map
		List<String> dishesNames = getDishesNames(menu);
		
		//using flatMap
		List<String> dishsNamesOnlyDistinctLetters = getDistinctLetters(menu);
		
		//All match
		//Check if our whole menue is very health i.e. under 1000 cal.
		if(menu.stream().allMatch(d-> d.getCalories()<1000)){
			System.out.println("our menu items are all below 1000 cals");
		}else{
			System.out.println("We still got some fat foods");
		}
		
		//Any match
		//Check if we have at least one healthy item
		if(menu.stream().anyMatch(d -> d.getCalories()<1000)){
			System.out.println("We are somewhat healthy");
		}else{
			System.out.println("We are fat only");
		}
		
		//none match
		//Find if we are whole menu is healthy using noneMatch method
		if(menu.stream().noneMatch(d->d.getCalories()>=1000 )){
			System.out.println("our menu items are all below 1000 cals");
		}else{
			System.out.println("We still got some fat foods");
		}
		
		//find first
		//Find first element that is under 1000 cals
		//Optional prevents null pointer exceptions and more..
		Optional<Dish> dish = menu.stream().filter(d->d.getCalories()<1000).findFirst();
		
		//find any
		//Find any Dish that is healthy.  Use findAny over findFirst bc it allows parallelism.  Only use findFirst when order matters.
		//Will also show how to take advatage of the type Optional<T>
			//If dish is healthy say something.  Notice how null pointer is avoided in Optional <T> type and gives nice methods that allow us to behave differently based on if a value is present or not.
		menu.stream().filter(d->d.getCalories()<1000).findAny().ifPresent(d-> System.out.println("This dish is healthy" + d.getName()));
		
		//Reducing - finding the Sum of all cals
		Integer allMenusCals = menu.stream().map(Dish::getCalories).reduce(0, (a,b)-> a+b);
		System.out.println(allMenusCals);
		
		
		//Reducing - finding the max and min of cals
		Optional<Integer> max = menu.stream().map(Dish::getCalories).reduce(Integer::max);
		if(max.isPresent())
			System.out.println("The max cals in our menu is " + max );
		
		Optional<Integer>min = menu.stream().map(Dish::getCalories).reduce(Integer::min);
		if(min.isPresent())
			System.out.println("The min cals in our menu is " + min);
		
		IntSummaryStatistics  menuStatistics = menu.stream().collect(summarizingInt(Dish::getCalories));
		System.out.println("this is the summary of the menu items: " + menuStatistics);
		
		//Traders and Transaction Domain:
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario","Milan");
		Trader alan = new Trader("Alan","Cambridge");
		Trader brian = new Trader("Brian","Cambridge");

		List<Transaction> transactions = Arrays.asList(
		    new Transaction(brian, 2011, 300),
		    new Transaction(raoul, 2012, 1000),
		    new Transaction(raoul, 2011, 400),
		    new Transaction(mario, 2012, 710),
		    new Transaction(mario, 2012, 700),
		    new Transaction(alan, 2012, 950)
		);
		
		// Find all transactions in the year 2011 and sort them by value (small to high).
		List<Transaction> transIn2011SmallToHigh = transactions.stream()
																.filter(t -> t.getYear()==2011)
																.sorted(comparing(Transaction::getValue))
																.collect(toList());
		
		//What are all the unique cities where the traders work?
		Set<String> unqiueCitiesWhereTradersWork = transactions.stream().map(t -> t.getTrader().getCity()).collect(toSet());
		
		
		
		
		
		
	}

	private static List<String> getDistinctLetters(List<Dish> menu) {
		return menu.stream()
					.map(Dish::getName)
					.map(dishNameStr -> dishNameStr.split(""))
					.flatMap(Arrays::stream)
					.distinct()
					.collect(toList());
	}

	private static List<String> getDishesNames(List<Dish> menu) {
		return menu.stream()
					.map(Dish::getName)
					.collect(toList());
	}

	private static List<Dish> skipFirst2BringBackOthersUnder300Cal(List<Dish> menu) {
		return menu.stream()
					.filter(d -> d.getCalories() < 300)
					.skip(2)
					.collect(toList());
	}

	private static List<Dish> getFirst3Under300(List<Dish> menu) {
		return menu.stream()
					.filter( d -> d.getCalories()<300)
					.limit(3)
					.collect(toList());
					
	}

	private static List<Dish> getVegetarianMenu(List<Dish> menu) {
		return menu.stream()
			.filter(Dish::isVegetarian)
			.collect(toList());
	}

}
