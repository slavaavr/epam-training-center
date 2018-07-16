package ava.java_school.java_se_04.task1;

import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        KeywordStatisticsInFile statistics = new KeywordStatisticsInFile();
        statistics.parse(Paths.get("src/main/java/ava/java_school/java_se_04/task1/fileForTest"), Paths.get("src/main/java/ava/java_school/java_se_04/task1/keyWords"));
        for (KeywordStatisticsInFile.KeywordCount keywordCount : statistics.getKeywordCountList()) {
            System.out.printf("%s = %s\n", keywordCount.getKeyword(), keywordCount.getCount());
        }
        statistics.printStatisticIntoTheFile(Paths.get("src/main/java/ava/java_school/java_se_04/task1/out"));
    }
}
