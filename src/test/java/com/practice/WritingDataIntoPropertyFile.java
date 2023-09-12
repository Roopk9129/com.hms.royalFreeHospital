package com.practice;

import java.io.FileOutputStream;
import java.util.Properties;

public class WritingDataIntoPropertyFile {

	public static void main(String[] args) throws Throwable {
		Properties prop = new Properties();
		prop.setProperty("url", "https://amazon.in");
		prop.setProperty("un", "admin");
		prop.setProperty("psd", "admin");
		
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\practice\\Practice1.properties");
		prop.store(fos, "write data");
		fos.close();
	}

}
