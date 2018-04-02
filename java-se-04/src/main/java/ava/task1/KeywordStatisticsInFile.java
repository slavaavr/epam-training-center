package ava.task1;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class KeywordStatisticsInFile {

    private List<KeywordCount> keywordCountList;

    public KeywordStatisticsInFile() {
        keywordCountList = new ArrayList<>();
    }

    public List<KeywordCount> getKeywordCountList() {
        return keywordCountList;
    }

    public void parse(Path pathToFile, Path pathToKeywords){
        StringBuilder keywords = new StringBuilder();
        byte[] buff = new byte[1024];
        try(BufferedInputStream brForKeywords = new BufferedInputStream(new FileInputStream(pathToKeywords.toString()));
                BufferedInputStream brForFile = new BufferedInputStream(new FileInputStream(pathToFile.toString()))){
            while(brForKeywords.read(buff) != -1){
                keywords.append(new String(buff));
            }
            initKeywordCountList(keywords.toString());
            while (brForFile.read(buff) != -1){
                for (KeywordCount keywordCount : keywordCountList) {
                    keywordCount.addCount(countSubstringWithinString(new String(buff),keywordCount.getKeyword()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initKeywordCountList(String words){
        String[] strings = words.split("\r\n");
        for (String string : strings) {

            keywordCountList.add(new KeywordCount(string, 0));

        }
    }

    private int countSubstringWithinString(String string, String substring){
        int count = 0;
        int offset = 0;
        while((offset = string.indexOf(substring, offset))!=-1){
            offset++;
            count++;
        }
        return count;
    }

    public static class KeywordCount{
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
