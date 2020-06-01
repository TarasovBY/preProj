package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyReader {

    private static Map<String, String> properties;

    private static PropertyReader propertyReader;

    private PropertyReader() {

    }

    public static PropertyReader getInstance() {
        if(propertyReader == null) {
            propertyReader = new PropertyReader();
        }
        return propertyReader;
    }


    public static Map<String, String> getProperties() {
        if(properties == null) {
            properties = createProperties();
        }
        return properties;
    }


    private static Map<String, String> createProperties()  {
        try {
            Properties property = new Properties();
            InputStream input = PropertyReader.class.getClassLoader().getResourceAsStream(".properties");
            property.load(input);
            return new HashMap(property);
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


}
