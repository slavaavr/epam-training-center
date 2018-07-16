package ava.java_se_07.task2;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropertyReader extends Thread {
    private Properties properties;
    private String fileName;

    public PropertyReader(String fileName) {
        this.fileName = fileName;
        this.properties = new Properties();
    }

    public PropertyReader() {
        this.properties = new Properties();
    }

    public void readPropFile() {
        start();
    }

    public void readPropFile(String fileName) {
        this.fileName = fileName;
        start();
    }

    public Set<String> getKeys() {
        return properties.stringPropertyNames();
    }

    public String getValue(String key) {
        return this.properties.getProperty(key);
    }

    @Override
    public void run() {
        try {
            synchronized (this.fileName){
                System.out.printf("Thread %s is open\n", Thread.currentThread().getName());
                System.out.printf("property file - %s downloading ...\n", fileName);
                this.properties.load(new FileInputStream(fileName));
                System.out.printf("Thread %s is close\n", Thread.currentThread().getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
