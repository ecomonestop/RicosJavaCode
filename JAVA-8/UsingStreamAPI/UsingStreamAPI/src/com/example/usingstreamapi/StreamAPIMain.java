package com.example.usingstreamapi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;

public class StreamAPIMain {

	public static void main(String[] args) {
		Developer developer = new Developer();
		// Steam API eliminates boilerplate code when filtering and grouping
		// collections:
		@SuppressWarnings("unused")
		Map<String, List<Developer>> javaDevelopers = streamApiSolveBoilerPlateFilterAndGroup(
				developer.getDevelopers());
		// Stream API allows "almost free" parallel processing
		streamApiSolveParallelProcessing(developer.getDevelopers());

	}

	private static void streamApiSolveParallelProcessing(List<Developer> developers) {
		//Sequential processing:
		List<Developer> oldDevelopers = developers.stream()
				.filter((Developer dev) -> dev.getAge()>30)
				.collect(toList());
		//Parallel processing:
		List<Developer> oldDevelopersInParallel = developers.parallelStream()
				.filter((Developer dev)-> dev.getAge()>30)
				.collect(toList());
	}

	/**
	 * 
	 * @param developers
	 * @return
	 * 
	 * 		Not too good of a real life example because we are grouping by
	 *         the same thing we are filtering on, but you get the point There
	 *         is many steps to take to say filter by this and group by this.
	 *         Stream API fixes this issue
	 */
	private static Map<String, List<Developer>> oldWayBoilerPlateFilterAndGroup(List<Developer> developers) {
		Map<String, List<Developer>> boilerPlateFilterAndGroup = new HashMap<>();
		for (Developer developer : developers) {
			if (developer.getPrimaryLanguage().equalsIgnoreCase("Java")) {
				List<Developer> javaDevelopers = boilerPlateFilterAndGroup.get("Java");
				if (javaDevelopers == null) {
					javaDevelopers = new ArrayList<>();
					boilerPlateFilterAndGroup.put("Java", javaDevelopers);
				}
				javaDevelopers.add(developer);
			}

		}

		return boilerPlateFilterAndGroup;

	}

	private static Map<String, List<Developer>> streamApiSolveBoilerPlateFilterAndGroup(List<Developer> developers) {
		return developers.stream().filter((Developer dev) -> dev.getPrimaryLanguage().equalsIgnoreCase("Java"))
				.collect(Collectors.groupingBy(Developer::getPrimaryLanguage));
	}

}
