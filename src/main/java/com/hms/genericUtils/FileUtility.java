package com.hms.genericUtils;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * This class is to write and read the files from external resources
 * 
 */
public class FileUtility {
	/**
	 * This method is used to fetch the commons from property file
	 * 
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String propertyFileDataFetch(String key) throws Throwable {
		Properties prop = new Properties();
		prop.load(new FileInputStream(IPathConstants.propertyFilePath));
		return prop.getProperty(key);
	}
	

}
