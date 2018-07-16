package ava.java_school.java_se_08.task1;

import ava.java_school.java_se_08.task1.entity.Person;

import java.sql.*;
import java.util.Optional;

public class PersonRepository {
    private Connection cnn;

    public PersonRepository(Connection cnn) {
        this.cnn = cnn;
    }

    public void addPerson(Person person) {
        try (PreparedStatement statement = cnn.prepareStatement("INSERT INTO PERSON VALUES (DEFAULT,?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, person.getName());
            statement.setString(2, person.getLastName());
            statement.executeUpdate();
            //------------
            // после добавляения записи в таблицу, id'шники записываются в объект Person, чтобы пользователь мог к ним обращаться
            ResultSet genkeys = statement.getGeneratedKeys();
            genkeys.next();
            int id = genkeys.getInt(1);
            person.setId(id);
            //-----------
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Optional<Person> getPerson(int id) {
        Person person = null;
        try (PreparedStatement statement = cnn.prepareStatement("SELECT * FROM PERSON WHERE id = ?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                person = new Person(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.printf("Человек c id=%s не найден\n", id);
        }
        return Optional.ofNullable(person);
    }

    public void updatePerson(Person oldPerson, Person newPerson) {
        updatePerson(oldPerson.getId(), newPerson);
    }

    public void updatePerson(int id, Person newPerson) {
        if (newPerson == null) {
            System.out.println("Пользователь не был передан для обновления!");
            return;
        }
        try (PreparedStatement statement =
                     cnn.prepareStatement("UPDATE PERSON SET name = ?, lastName = ? WHERE id = ?")) {
            statement.setString(1, newPerson.getName());
            statement.setString(2, newPerson.getLastName());
            statement.setInt(3, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.printf("Запись не была обновлена, т.к. не был найден человек с id=%s", id);
        }
    }

    public void printPersons() {
        try (Statement statement = cnn.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM PERSON");
            while (resultSet.next()) {
                System.out.printf("id: %s | name: %s | lastName: %s\n",
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
