package com.qa.ecommerce.utils;

import java.io.InputStream;
import java.util.Properties;

public class ApiTestDataReader {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ApiTestDataReader.class
                .getClassLoader()
                .getResourceAsStream("api-testdata.properties")) {

            if (input == null) {
                throw new RuntimeException(
                        "api-testdata.properties not found in resources"
                );
            }

            properties.load(input);

        } catch (Exception e) {
            throw new RuntimeException(
                    "Failed to load api-testdata.properties",
                    e
            );
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}