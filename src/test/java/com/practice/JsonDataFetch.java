package com.practice;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonDataFetch {

	public static void main(String[] args) throws Throwable {
		JSONParser jp = new JSONParser();
		FileReader fr = new FileReader(".\\src\\test\\resources\\practice\\file1.json");
		Object obj = jp.parse(fr);
		JSONObject map = (JSONObject) obj;

		System.out.println(map.get("BROWSER"));
		System.out.println(map.get("URL"));
		System.out.println(map.get("USERNAME"));
		System.out.println(map.get("PASSWORD"));
		

	}

}
