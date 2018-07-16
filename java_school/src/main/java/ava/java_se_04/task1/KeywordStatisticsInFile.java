package ava.java_se_04.task1;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        byte[] buff;
        try (BufferedInputStream brForKeywords = new BufferedInputStream(new FileInputStream(pathToKeywords.toString()));
             BufferedInputStream brForFile = new BufferedInputStream(new FileInputStream(pathToFile.toString()))) {
            buff = new byte[brForKeywords.available()];
            while (brForKeywords.read(buff) != -1) {
                keywords.append(new String(buff));
            }
            initKeywordCountList(keywords.toString());
            buff = new byte[brForFile.available()];
            while (brForFile.read(buff) != -1) {
                String string = new String(buff);
                for (KeywordCount keywordCount : keywordCountList) {
                    keywordCount.addCount(countSubstringWithinString(string, keywordCount.getKeyword()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printStatisticIntoTheFile(Path path){
        StringBuilder builder = new StringBuilder();
        for (KeywordCount keywordCount : keywordCountList) {
            builder.append(keywordCount.getKeyword()).append(" ").append(keywordCount.count).append("\n");
        }
        try(BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream(path.toString()))){
            bw.write(builder.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initKeywordCountList(String words) {
        String[] strings = words.split("\r\n");
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
//        int count = 0;
//        int lastIndex = 0;
//        while ((lastIndex = string.indexOf(substring, lastIndex)) != -1) {
//            lastIndex += substring.length() - 1;
//            count++;
//        }
        return count;
    }

    public static class KeywordCount {
        private String keyword;
        private int count;

        public String getKeyword() {
            return keyword;
        }

        public void setKeyword(String keyword) {
            this.keyword = keyword;
        }

        public void addCount(int count) {
            this.count += count;
        }

        public int getCount() {
            return count;
        }

        public KeywordCount(String keyword, int count) {
            this.keyword = keyword;
            this.count = count;
        }

        @Override
        public String toString() {
            return "KeywordCount{" +
                    "keyword='" + keyword + '\'' +
                    ", count=" + count +
                    '}';
        }
    }
}
