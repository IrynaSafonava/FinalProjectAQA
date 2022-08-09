package by.it_academy.onliner.framework;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    private static final String PROPERTIES_FILE = "/application.properties";
    private static final Properties APPLICATION_PROPERTIES = new Properties();

    static {
        initProperties(APPLICATION_PROPERTIES, PROPERTIES_FILE);
    }

    public static String getEndpointProperty(String property) {
        return APPLICATION_PROPERTIES.getProperty(property);
    }

    private static synchronized void initProperties(Properties properties, String fileName)
            throws IllegalArgumentException {
        try (InputStream inputStream = PropertiesReader.class
                .getResourceAsStream(fileName)) {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new IllegalArgumentException(
                    "Unable to load property from file" + fileName);
        }
    }
}
