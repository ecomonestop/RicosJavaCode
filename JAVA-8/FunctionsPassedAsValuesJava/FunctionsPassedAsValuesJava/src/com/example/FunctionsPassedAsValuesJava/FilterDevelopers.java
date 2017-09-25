package com.example.FunctionsPassedAsValuesJava;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FilterDevelopers {
	
	
	public static void main (String[] args){
		//Calling the new way of filtering with Named function and lambdas (anonymous  function)
		//I use function because we are passing it in as a value, a first class citizen, which constitutes it to be referred as a function
		FilterDevelopers fDev = new FilterDevelopers();
		
		//Named function call
		List<Developer> developersa = fDev.filterDevelopersNewWay(Developer::isNamedRico);
		//anonymous  function (aka lambdas) call
		List<Developer> developersb = fDev.filterDevelopersNewWay((Developer dev) -> dev.getYearsOfExperience() > 3);
		List<Developer> developersc = fDev.filterDevelopersNewWay((Developer dev) -> dev.getPrimaryLanguage().equals("Java"));
		
	}
	
	
	private List<Developer> developers;
	
	public FilterDevelopers(){
		developers = new ArrayList<>();
		Developer dev1 = new Developer();
		Developer dev2 = new Developer();
		Developer dev3 = new Developer();
		Developer dev4 = new Developer();
		Developer dev5 = new Developer();
		
		dev1.setName("Rico");
		dev1.setAge(26);
		dev1.setPrimaryLanguage("Java");
		dev1.setYearsOfExperience(5);
		
		dev2.setName("Nico");
		dev2.setAge(19);
		dev2.setPrimaryLanguage("C#");
		dev2.setYearsOfExperience(1);
		
		dev3.setName("Pico");
		dev3.setAge(35);
		dev3.setPrimaryLanguage("Go");
		dev3.setYearsOfExperience(10);
		
		dev4.setName("Chico");
		dev4.setAge(46);
		dev4.setPrimaryLanguage("JavaScript");
		dev4.setYearsOfExperience(15);
		
		dev5.setName("Tico");
		dev5.setAge(23);
		dev5.setPrimaryLanguage("SQL");
		dev5.setYearsOfExperience(2);
		
		
		developers.add(dev1);
		developers.add(dev2);
		developers.add(dev3);
		developers.add(dev4);
		developers.add(dev5);
		
	}
	
	/**
	 * 
	 * @param yearsOfExpereince  years of experience required for consideration of job
	 * @return  list of developers that meet or exceed years of expereince required.
	 * 
	 * Note that in this old way of doing things (prior to java 8) you would have to write other filter methods that do the same thing,
	 * duplication of code, except for the condition your filtering on.
	 * 
	 * In Java 8, you can use a Predicate from java.util.function
	 * 
	 */
	public List<Developer> filterOldWayYearsOfExperience(Integer yearsOfExpereince){
		List<Developer> developersWExperience = new ArrayList<>();
		
		for (Developer developer : developers) {
			if (developer.getYearsOfExperience()>= yearsOfExpereince){
				developersWExperience.add(developer);
			}
		}
		
		return developersWExperience;
		
	}
	
	/**
	 * 
	 * @param dev  - Predicate, which is a function that takes in a value and returns a boolean
	 * @return  - list of developers that meet the condition passed in via the predicate dev variable
	 * 
	 * This is the new way of filtering in Java 8.  No longer do you have to violate DRY, you can write one method that
	 * handles any future filtering needs.  For example, today I want to sort on developers experience, but tomorrow I would like to
	 * filter on primary language.  This can be handled by the one method below.
	 * 
	 */
	public List<Developer> filterDevelopersNewWay(Predicate<Developer> dev){
		List<Developer> resultOfFilter = new ArrayList<>();
		
		for (Developer developer : developers) {
			if(dev.test(developer)){
				resultOfFilter.add(developer);
			}
		}
		
		return resultOfFilter;
		
	}
	
	

}
