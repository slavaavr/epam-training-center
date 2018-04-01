package main.ava.task1;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.stream.Collectors;

public class CrazyLogger {
    private StringBuilder buff;
    private static final String DATE_TIME_FORMAT = "dd-MM-YYYY : hh-mm - ";

    public CrazyLogger(){
        buff = new StringBuilder();
    }

    public void info(String msg){
        buff.append(LocalDateTime
                        .now()
                        .format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT))
                    ).append(msg).append("\n");
    }

    public String findByString(String string){
        String[] strings = buff.toString().split("\n");
        return Arrays.stream(strings).filter(s -> s.contains(string)).collect(Collectors.joining("\n"));
    }

    public void reset(){
        buff = new StringBuilder();
    }

}
