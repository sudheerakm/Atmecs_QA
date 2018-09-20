package com.amazon;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	
public static Properties readProperties(String filename) throws Exception{
	
		//Trim the file
		
		filename = filename.trim();
		
		//Read the file from FileInputStream
		InputStream fileReader = new FileInputStream(filename);
		
		//Initial the property object
		Properties property = new Properties();
		
		//load the file
		property.load(fileReader);
		
		return property;
		
		
	}


}
