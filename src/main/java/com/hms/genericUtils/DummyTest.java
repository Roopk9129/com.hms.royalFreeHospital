package com.hms.genericUtils;

import java.util.List;

public class DummyTest {

	public static void main(String[] args) throws Throwable {
		ExcelFileUtility EU = new ExcelFileUtility();
		String s =EU.pullMultipleDataFromSheet("Doctor_Details__AdminModule");
		System.out.println(s);
	}

}
