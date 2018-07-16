package ava.java_school.java_se_06.task2;

import java.util.*;

/**
 * Ответьте на вопрос: как ведет себя map-коллекция если в нее
    добавить элемент с ключом, который уже присутствует?
 - При добавлении элемента в map-коллекцию,
    возвращается предыдущее значение и заменяется новым.
 */
public class PropertyReader {
    private Map<String, String> propertiesMap;

    public PropertyReader() {
       this.propertiesMap = new HashMap<>();
    }

    public void readPropFile(String fileName) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(fileName);
        for (String key : resourceBundle.keySet()) {
            this.propertiesMap.put(key, resourceBundle.getString(key));
        }
    }

    public Set<String> getKeys() {
        return propertiesMap.keySet();
    }

    public String getValue(String key) {
        return this.propertiesMap.get(key);
    }
}
