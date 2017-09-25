package com.example.userdefinedfunctionalnterface;

/**
 * 
 * @author 212604352
 * 
 * A functional interface is one that specifies exactly one abstract method
 * Note that the @FunctionalInterface is best practice when defining a functional interface.  This will give you a compile error
 * if for example you try to define two abstract methods.
 */
@FunctionalInterface
public interface UserDefinedFunctionalInterface {
	
	String helloWorldTextPrint();
	

}
