package ava.java_se_04.task2;

import java.nio.file.Paths;
import ava.java_se_04.task1.KeywordStatisticsInFile.KeywordCount;

public class Main {
    public static void main(String[] args) {
        KeywordStatisticsInFile statistics = new KeywordStatisticsInFile();
        statistics.parse(Paths.get("java_school/src/main/java/ava/java_se_04/task2/fileForTest"), Paths.get("java_school/src/main/java/ava/java_se_04/task2/keyWords"));
        for (KeywordCount keywordCount : statistics.getKeywordCountList()) {
            System.out.printf("%s = %s\n", keywordCount.getKeyword(), keywordCount.getCount());
        }
        statistics.printStatisticIntoTheFile(Paths.get("java_school/src/main/java/ava/java_se_04/task2/out"));
    }
}
