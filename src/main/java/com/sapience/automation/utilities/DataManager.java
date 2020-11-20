package com.sapience.automation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author kohitij_das
 */
public class DataManager {

    static Properties properties = null;
    private static DataManager INSTANCE = null;

    public DataManager() {
    }

    public static DataManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DataManager();
            initialiseProperties();
        }
        return INSTANCE;
    }

    private static void initialiseProperties() {

        properties = new Properties();
        try {
            String propertyFileName = "automation.properties";
            String filePath = new File(propertyFileName).getAbsolutePath();
            File configFile = new File(filePath);

            FileInputStream inputStream = new FileInputStream(configFile);
            properties.load(inputStream);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Properties getPropertiesData() {
        return properties;
    }
}