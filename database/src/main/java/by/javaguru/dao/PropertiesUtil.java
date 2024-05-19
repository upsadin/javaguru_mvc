package by.javaguru.dao;

import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {

    private PropertiesUtil() {
    }

    private static final Properties PROPERTIES = new Properties();

    private static void loadProperties() {
        try (var inputStream = PropertiesUtil.class
                .getClassLoader().getResourceAsStream("application.properties")) {
            PROPERTIES.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String get(String key) {
        loadProperties();
        return PROPERTIES.getProperty(key);
    }
}
