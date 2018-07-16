package ava.java_school.java_se_04.task2;

import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        KeywordStatisticsInFile statistics = new KeywordStatisticsInFile();
        statistics.parse(Paths.get("ava/java_school/java_se_04/task2/fileForTest"), Paths.get("ava/java_school/java_se_04/task2/keyWords"));
        for (ava.java_school.java_se_04.task1.KeywordStatisticsInFile.KeywordCount keywordCount : statistics.getKeywordCountList()) {
            System.out.printf("%s = %s\n", keywordCount.getKeyword(), keywordCount.getCount());
        }
        statistics.printStatisticIntoTheFile(Paths.get("ava/java_school/java_se_04/task2/out"));
    }
}
