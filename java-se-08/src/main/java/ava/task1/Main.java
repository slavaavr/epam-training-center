package ava.task1;

import ava.task1.entity.Person;
import org.h2.tools.RunScript;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//таблица не удаляется в конце, т.к. использовалась in memory db h2
public class Main {
    private static final String SCHEMA = "java-se-08/src/main/java/ava/task1/schema.sql";

    public static void main(String[] args) {
        try (Connection cnn = DriverManager.getConnection("jdbc:h2:mem:")) {
            RunScript.execute(cnn, new FileReader(SCHEMA));
            PersonRepository personRepository = new PersonRepository(cnn);
            personRepository.addPerson(new Person("John", "Doe"));
            personRepository.addPerson(new Person("Bob", "Richer"));
            personRepository.addPerson(new Person("Alice", "Green"));
            personRepository.printPersons();
            personRepository.getPerson(2).ifPresent(System.out::println);
            personRepository.updatePerson(2, new Person("Jack", "Richer"));
            personRepository.printPersons();
        } catch (FileNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
