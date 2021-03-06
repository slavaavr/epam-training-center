package ava.java_se_04.task2;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ava.java_se_04.task1.KeywordStatisticsInFile.KeywordCount;

public class KeywordStatisticsInFile {
    private List<KeywordCount> keywordCountList;

    public KeywordStatisticsInFile() {
        keywordCountList = new ArrayList<>();
    }

    public List<KeywordCount> getKeywordCountList() {
        return keywordCountList;
    }

    public void parse(Path pathToFile, Path pathToKeywords) {
        StringBuilder keywords = new StringBuilder();
        try (BufferedReader brForKeywords = new BufferedReader(new FileReader(pathToKeywords.toString()));
             BufferedReader brForFile = new BufferedReader(new FileReader(pathToFile.toString()))) {
            String line;
            while ((line = brForKeywords.readLine()) != null) {
                keywords.append(line).append("\n");
            }
            initKeywordCountList(keywords.toString());
            while ((line = brForFile.readLine()) != null) {
                for (KeywordCount keywordCount : keywordCountList) {
                    keywordCount.addCount(countSubstringWithinString(line, keywordCount.getKeyword()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printStatisticIntoTheFile(Path path) {
        StringBuilder builder = new StringBuilder();
        for (KeywordCount keywordCount : keywordCountList) {
            builder.append(keywordCount.getKeyword()).append(" ").append(keywordCount.getCount()).append("\n");
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path.toString()))) {
            bw.write(builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initKeywordCountList(String words) {
        String[] strings = words.split("\n");
        for (String string : strings) {
            keywordCountList.add(new KeywordCount(string, 0));
        }
    }

    private int countSubstringWithinString(String string, String substring) {
        Pattern p = Pattern.compile(substring + "\\s");
        Matcher m = p.matcher(string);
        int count = 0;
        while (m.find()) {
            count += 1;
        }
        return count;
    }
}
