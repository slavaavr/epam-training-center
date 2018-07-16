package ava.java_se_08.task2;

import ava.java_se_08.task2.entity.Book;
import org.h2.tools.RunScript;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    private static final String SCHEMA = "java_school/src/main/java/ava/java_se_08/task2/schema.sql";

    public static void main(String[] args) {
        try (CnnPool pool = new CnnPool(5);
             Connection connection = pool.getConnection()) {
            RunScript.execute(connection, new FileReader(SCHEMA));
            BookRepository bookRepository = new BookRepository(connection);
            bookRepository.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "Novel"));
            bookRepository.addBook(new Book("War and Peace", "Leo Tolstoy", "Novel (Historical novel)"));

            try (Connection connection1 = pool.getConnection()) {
                BookRepository repository = new BookRepository(connection1);
                repository.addBook(new Book("Hamlet", "William Shakespeare", "Drama"));
            }
            bookRepository.printBooks();
            System.out.println("________________");
            bookRepository.deleteBook(3);
            bookRepository.printBooks();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
