package com.cybertek.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties = new Properties(); //we can create object

    static {
        try {
            //open the file using inputStream
            FileInputStream inputStream = new FileInputStream("configuration.properties"); // constructor

            //load to properties object
            properties.load(inputStream);

            //close the file after loading. Free up memory
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error occurred while reading configuration file");
        }
    }


    /**
     * Method is used to read value from a configuration.properties file
     *
     * @param key -> key name in properties file
     * @return -> value for the key
     */
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
