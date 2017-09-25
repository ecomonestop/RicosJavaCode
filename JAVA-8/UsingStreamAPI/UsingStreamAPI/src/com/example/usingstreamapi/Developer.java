package com.example.usingstreamapi;

import java.util.ArrayList;
import java.util.List;

public class Developer {
	
	private String primaryLanguage;
	private String name;
	private Integer age;
	private Integer yearsOfExperience;
	
	
	
	public String getPrimaryLanguage() {
		return primaryLanguage;
	}
	public void setPrimaryLanguage(String primaryLanguage) {
		this.primaryLanguage = primaryLanguage;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getYearsOfExperience() {
		return yearsOfExperience;
	}
	public void setYearsOfExperience(Integer yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}
	
	public List<Developer> getDevelopers(){
		List<Developer> developers = new ArrayList<>();
		Developer dev1 = new Developer();
		Developer dev1a = new Developer();
		Developer dev2 = new Developer();
		Developer dev3 = new Developer();
		Developer dev4 = new Developer();
		Developer dev5 = new Developer();
		
		dev1.setName("Rico");
		dev1.setAge(26);
		dev1.setPrimaryLanguage("Java");
		dev1.setYearsOfExperience(5);
		
		dev1a.setName("Rico");
		dev1a.setAge(26);
		dev1a.setPrimaryLanguage("Java");
		dev1a.setYearsOfExperience(5);
		
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
		developers.add(dev1a);
		developers.add(dev2);
		developers.add(dev3);
		developers.add(dev4);
		developers.add(dev5);
		
		return developers;
	}
	
	public boolean isNamedRico(){
		if(this.getName().equalsIgnoreCase("Rico")){
			return true;
		}
		return false;
	}
	

}
