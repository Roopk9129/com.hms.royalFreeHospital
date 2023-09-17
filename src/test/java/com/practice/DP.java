package com.practice;

import org.testng.annotations.Test;

public class DP {
	@Test(dataProviderClass = SetOfData.class,dataProvider = "furniture")
	public void FetchData(String Product, int price, String size) {
		System.out.println(Product+" "+price+" "+size);
		
		
		
	}

}
