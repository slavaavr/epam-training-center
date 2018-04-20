package ava.task2;

import ava.task2.entity.Book;

import java.sql.*;
import java.util.Optional;

public class BookRepository {
    private Connection cnn;

    public BookRepository(Connection cnn) {
        this.cnn = cnn;
    }

    public void addBook(Book book) {
        try (PreparedStatement statement = cnn.prepareStatement("INSERT INTO BOOKS VALUES (DEFAULT, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setString(3, book.getGenre());
            statement.executeUpdate();
            //------------
            // после добавляения записи в таблицу, id'шники записываются в объект Book, чтобы пользователь мог к ним обращаться
            ResultSet genkeys = statement.getGeneratedKeys();
            genkeys.next();
            int id = genkeys.getInt(1);
            book.setId(id);
            //-----------
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Optional<Book> getBook(int id) {
        Book book = null;
        try (PreparedStatement statement = cnn.prepareStatement("SELECT * FROM BOOKS WHERE id = ?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                book = new Book(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.printf("Книга c id=%s не найдена\n", id);
        }
        return Optional.ofNullable(book);
    }

    public void updateBook(Book oldBook, Book newBook) {
        updateBook(oldBook.getId(), newBook);
    }

    public void updateBook(int id, Book newBook) {
        if (newBook == null) {
            System.out.println("Книга не была передана для обновления!");
            return;
        }
        try (PreparedStatement statement =
                     cnn.prepareStatement("UPDATE BOOKS SET title = ?, author = ?, genre = ? WHERE id = ?")) {
            statement.setString(1, newBook.getTitle());
            statement.setString(2, newBook.getAuthor());
            statement.setString(2, newBook.getGenre());
            statement.setInt(4, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.printf("Запись не была обновлена, т.к. не была найдена книга с id=%s", id);
        }
    }

    public void deleteBook(int id) {
        try (PreparedStatement statement = cnn.prepareStatement("DELETE FROM BOOKS WHERE id = ?")) {
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printBooks() {
        try (Statement statement = cnn.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM BOOKS");
            while (resultSet.next()) {
                System.out.printf("id: %s | title: %s | author: %s | genre: %s\n",
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
