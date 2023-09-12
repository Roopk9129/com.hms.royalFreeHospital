package com.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyDemo {

	public static void main(String[] args) throws Throwable {
		FileInputStream FIS = new FileInputStream(".\\src\\test\\resources\\CommonFilw.properties");
		Properties prop = new Properties();
		prop.load(FIS);;
		System.out.println(prop.getProperty("browser"));
		System.out.println(prop.getProperty("url"));
		System.out.println(prop.getProperty("un"));
		System.out.println(prop.getProperty("psd"));
	}

}
