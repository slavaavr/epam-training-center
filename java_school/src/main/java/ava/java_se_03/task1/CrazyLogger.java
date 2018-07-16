package ava.java_se_03.task1;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.stream.Collectors;

public class CrazyLogger {
    private StringBuilder buff;
    private static final String TIME_FORMAT = "hh-mm";
    private static final String DATE_FORMAT = "dd-MM-YYYY";
    private static final String DATE_TIME_FORMAT = String.format("%s : %s - ",DATE_FORMAT, TIME_FORMAT);

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
        return Arrays.stream(strings)
                .filter(s -> s.contains(string))
                .collect(Collectors.joining("\n"));
    }

    public String findByDate(LocalDate date){
        String[] strings = buff.toString().split("\n");
        return Arrays.stream(strings)
                .filter(s -> s.contains(date.format(DateTimeFormatter.ofPattern(DATE_FORMAT))))
                .collect(Collectors.joining("\n"));
    }

    public String findByTime(LocalTime time){
        String[] strings = buff.toString().split("\n");
        return Arrays.stream(strings)
                .filter(s -> s.contains(time.format(DateTimeFormatter.ofPattern(TIME_FORMAT))))
                .collect(Collectors.joining("\n"));
    }


    public void reset(){
        buff = new StringBuilder();
    }

    public String printLog(){
        return buff.toString();
    }

}
