package com.practice;

import org.testng.annotations.Test;

public class PracticeTest {
	@Test(priority = -1)
	public void create() {
		int[] a = {1,2,3};
		System.out.println(a[5]);
		System.out.println("---Created---");
	}

	@Test(priority = -2, dependsOnMethods = "create")
	public void edit() {
		System.out.println("---edited---");
	}

	@Test(priority = 0, invocationCount = -1)
	public void delete() {
		System.out.println("---deleted---");
	}

}
