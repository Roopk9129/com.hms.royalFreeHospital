package com.practice;

public class replace {

	public static void main(String[] args) {
		String sen = "I Use Selenium tool";
		String str = sen.replaceAll(" ", "");
		for (int i = str.length() - 1; i >= 0; i--) {
			System.out.print(str.charAt(i));

		}

	}

}
