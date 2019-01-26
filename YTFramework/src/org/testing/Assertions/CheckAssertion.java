package org.testing.Assertions;

import junit.framework.Assert;

public class CheckAssertion {
	
	public static void compare(String expected, String actual){
		
		if(expected.equals(actual)){
			
			System.out.println("Assertion passed!");
		}
		else{
			
			System.out.println("Assertion failed!");
		}
		
	}

}
