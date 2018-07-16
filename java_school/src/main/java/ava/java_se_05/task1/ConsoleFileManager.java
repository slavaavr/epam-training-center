package ava.java_se_05.task1;

import ava.java_se_05.task1.exception.CantClimbToCatalogAboveException;
import ava.java_se_05.task1.exception.CantCreateFileException;
import ava.java_se_05.task1.exception.PathNotExistException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

public class ConsoleFileManager {

    private static final String PATH_TO_MANUAL = "java_school/src/main/java/ava/java_se_05/task1/help";

    private File currentState;

    public ConsoleFileManager() {
        this.currentState = new File(".");
    }

    public ConsoleFileManager(String path) {
        this.currentState = new File(path);
        if (!this.currentState.exists() || this.currentState.isFile()) {
            throw new PathNotExistException(path);
        }
    }

    public String climbToFolderAbove() {
        this.currentState = Optional.ofNullable(this.currentState.getAbsoluteFile().getParentFile()).orElseThrow(CantClimbToCatalogAboveException::new);
        return getCurrentPath();
    }

    public String goToFolder(String path) {
        File file;
        file = getFileDependsOnPath(path);
        if (!file.exists() || file.isFile()) {
            throw new PathNotExistException(path);
        }
        this.currentState = file;
        return getCurrentPath();
    }

    public String getListOfFiles() {
        return Arrays.stream(this.currentState.list()).collect(Collectors.joining(System.lineSeparator()));
    }

    public boolean createFile(String fileName) {
        File file;
        file = getFileDependsOnPath(fileName);
        try {
            return file.createNewFile();
        } catch (IOException e) {
            throw new CantCreateFileException(e.getMessage());
        }
    }

    public boolean removeFile(String fileName) {
        File file;
        file = getFileDependsOnPath(fileName);
        if (!file.exists()) {
            throw new PathNotExistException(fileName);
        }
        return file.delete();
    }

    public void writeToFile(String fileName, String msg, boolean append) {
        msg = msg.concat(System.lineSeparator());
        File file;
        file = getFileDependsOnPath(fileName);
        if (!file.exists() || !file.isFile()) {
            throw new PathNotExistException(fileName);
        }
        try {
            if (append) {
                Files.write(Paths.get(file.toURI()), msg.getBytes(), StandardOpenOption.APPEND);
            } else {
                Files.write(Paths.get(file.toURI()), msg.getBytes());
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public String printFile(String fileName) {
        File file;
        file = getFileDependsOnPath(fileName);
        if (!file.exists() || !file.isFile()) {
            throw new PathNotExistException(fileName);
        }
        try {
            return new String(Files.readAllBytes(Paths.get(file.toURI())));
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public String getCurrentPath() {
        return this.currentState.getAbsolutePath();
    }

    private File getFileDependsOnPath(String path) {
        File file;
        if (Paths.get(path).isAbsolute()) {
            file = new File(path);
        } else {
            file = new File(String.format("%s/%s", getCurrentPath(), path));
        }
        return file;
    }

    public String getHelp() {
        String helpInfo = "";
        try {
            helpInfo = Files.lines(Paths.get(PATH_TO_MANUAL)).collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return helpInfo;
    }

}
