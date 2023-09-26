package com.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionsPractice {
	@Test
	public void hardAssert() {
		Assert.assertNotEquals("A", "b","ffailed");
		Assert.assertNotEquals(20, 30);
	
	}

}
