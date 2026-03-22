package com.thetestingacademy.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    //we have a data.properties file - which is a kind of all properties mentioned in a file
    //this is # Key = value pair format file

    //to read the data from data.properties file - we create this program

    //where as we have keys in the property file
    //we will pass the key
    //so that we can fetch the value of the given key from the file
    //this method is static - as this should be used by anyone in the project

    public static String readKey(String key){
        //the properties here is a class from java.util lib
        Properties p;
        String user_dir = System.getProperty("user.dir");
        //user.dir - C:\Users\pvani\IdeaProjects\ATB15xSeleniumAdvanceFramework
        //C:\Users\pvani\IdeaProjects\ATB15xSeleniumAdvanceFramework\src\main\resources\data.properties
        String file_path = user_dir+"/src/main/resources/data.properties";
        try {
            FileInputStream fileInputStream = new FileInputStream(file_path);
            p = new Properties();
            p.load(fileInputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return p.getProperty(key);
    }
}
