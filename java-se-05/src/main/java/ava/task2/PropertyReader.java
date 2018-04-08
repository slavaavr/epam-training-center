package ava.task2;


import ava.task2.exception.PropertyFileNotFoundException;
import ava.task2.exception.KeyNotFoundException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropertyReader {
    private Properties properties;

    public PropertyReader() {
        this.properties = new Properties();
    }

    public void readPropFile(String fileName) {
        try {
            this.properties.load(new FileInputStream(fileName));
        } catch (IOException e) {
            throw new PropertyFileNotFoundException(e.getMessage());
        }
    }

    public Set<String> getKeys() {
        return properties.stringPropertyNames();
    }

    public String getValue(String key) {
        if (!this.properties.containsKey(key)) {
            throw new KeyNotFoundException(String.format("Key - '%s' not found!", key));
        }
        return this.properties.getProperty(key);
    }
}
