package com.example.userdefinedfunctionalnterface;

/**
 * 
 * @author 212604352
 * 
 * This class will be used as the main class.  Overall, I will demonstrate how to create a User defined functional interface and how to use it.
 * This is a trivial example really just to explain what a functional interface is, the @FunctionalInterface annotation, and how to call 
 * a method that has a functional interface as an argument with a lambda expression
 *
 */
public class UserDefinedFunctionalInterfaceMain {

	public static void main(String[] args) {
		printMessage(()-> "Hello world");
		printMessage(()-> "Hello world again");

	}
	
	
	public static void printMessage(UserDefinedFunctionalInterface helloWorldText){
		System.out.println(helloWorldText.helloWorldTextPrint());
	}

}
