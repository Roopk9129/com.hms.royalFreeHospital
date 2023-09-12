package com.hms.genericUtils;

import java.util.Date;
import java.util.Random;

/**
 * This class consists of generic methods of Java
 * 
 * author S Roop Kumar
 * 
 * @param count
 * @return
 */
public class Java_Utils {

	/**
	 * This method is used to get random numbers of integer
	 * 
	 * @param count
	 * @return
	 */
	public int randomIntegerNumber(int count) {
		Random ran = new Random();
		return ran.nextInt(count);

	}

	/**
	 * This method is used to give the date and time in format
	 * 
	 * @return
	 */

	public String systemDateInFormat() {
		Date d = new Date();
		String[] str = d.toString().split(" ");
		String day = str[0];
		String month = str[1];
		String date = str[2];
		String year = str[5];
		String time = str[3].replaceAll(":", "-");

		return date + "-" + month + "-" + year + "_" + day + "_" + time;

	}

}
