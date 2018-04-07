package ava.task1;

import ava.task1.exception.CantClimbToCatalogAboveException;
import ava.task1.exception.CantCreateFileException;
import ava.task1.exception.PathNotExistException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

public class ConsoleFileManager {

    public static final String PATH_TO_MANUAL = "java-se-05/src/main/java/ava/task1/help";

    private File currentState;

    public ConsoleFileManager() {
        this.currentState = new File(".");
    }

    public ConsoleFileManager(String path) {
        this.currentState = new File(path);
        if (!this.currentState.exists() || this.currentState.isFile()) {
            throw new PathNotExistException(String.format("Cannot find path '%s' because it does not exist!", path));
        }
    }

    public static void main(String[] args) throws IOException {
        ConsoleFileManager fileManager = new ConsoleFileManager("C:/");
        System.out.println(fileManager.climbToFolderAbove());
//        System.out.println(fileManager.currentState.getAbsoluteFile().getParentFile().getCanonicalPath());

    }

    public String climbToFolderAbove() {
        this.currentState = Optional.ofNullable(this.currentState.getAbsoluteFile().getParentFile()).orElseThrow(CantClimbToCatalogAboveException::new);
        return getCurrentPath();
    }

    public String goToFolder(String path) {
        File file;
        if(Paths.get(path).isAbsolute()){
            file = new File(path);
        } else {
            file = new File(String.format("%s/%s", getCurrentPath(), path));
        }
        if (!file.exists() || file.isFile()) {
            throw new PathNotExistException(String.format("Cannot find path '%s' because it does not exist!", path));
        }
        this.currentState = file;
        return getCurrentPath();
    }

    public String getListOfFiles() {
        return Arrays.stream(this.currentState.list()).collect(Collectors.joining("\n"));
    }

    public boolean createFile(String fileName) {
        File file;
        if(Paths.get(fileName).isAbsolute()){
            file = new File(fileName);
        } else {
            file = new File(String.format("%s/%s", getCurrentPath(), fileName));
        }
        try {
            return file.createNewFile();
        } catch (IOException e) {
            throw new CantCreateFileException(e.getMessage());
        }
    }

    public boolean removeFile(String fileName) {
        File file;
        if(Paths.get(fileName).isAbsolute()){
            file = new File(fileName);
        } else {
            file = new File(String.format("%s/%s", getCurrentPath(), fileName));
        }
        if (!file.exists()) {
            throw new PathNotExistException(String.format("Cannot find path '%s' because it does not exist!", fileName));
        }
        return file.delete();
    }



    private String getCurrentPath() {
        return this.currentState.getAbsolutePath();
    }


    public String getHelp() {
        String helpInfo = "";
        try {
            helpInfo = Files.lines(Paths.get(PATH_TO_MANUAL)).collect(Collectors.joining());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return helpInfo;
    }

}
