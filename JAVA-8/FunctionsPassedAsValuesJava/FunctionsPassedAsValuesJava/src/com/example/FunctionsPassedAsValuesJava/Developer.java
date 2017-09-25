package com.example.FunctionsPassedAsValuesJava;

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
	
	public boolean isNamedRico(){
		if(this.getName().equalsIgnoreCase("Rico")){
			return true;
		}
		return false;
	}
	

}
