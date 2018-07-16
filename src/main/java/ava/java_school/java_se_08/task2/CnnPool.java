package ava.java_school.java_se_08.task2;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Delegate;
import lombok.experimental.FieldDefaults;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class CnnPool implements Closeable {

    BlockingQueue<PooledConnection> cnnPool;
    String urlToDB = "jdbc:h2:mem:library";

    public CnnPool(int capacity) {
        cnnPool = IntStream
                .range(0, capacity)
                .mapToObj(this::generateConnection)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toCollection(() -> new ArrayBlockingQueue<>(capacity)));
    }

    public Connection getConnection() {
        PooledConnection connection = null;
        try {
            connection = cnnPool.take();
            System.out.printf("[GET CONNECTION - %s FROM POOL]\n", connection.getId());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void close() {
        this.cnnPool.forEach(PooledConnection::reallyClose);
    }

    private Optional<PooledConnection> generateConnection(int id) {
        PooledConnection cnn = null;
        try {
            Connection connection = DriverManager.getConnection(this.urlToDB);
            cnn = new PooledConnection(connection, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(cnn);
    }

    @AllArgsConstructor
    @FieldDefaults(level = AccessLevel.PRIVATE)
    private class PooledConnection implements java.sql.Connection {
        @Delegate(excludes = Closeable.class)
        Connection connection;
        @Getter
        int id;

        @Override
        public void close() {
            System.out.printf("[PUT CONNECTION - %s TO POOL]\n", id);
            CnnPool.this.cnnPool.offer(this);
        }

        void reallyClose() {
            System.out.printf("[CLOSE CONNECTION - %s]\n", id);
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
