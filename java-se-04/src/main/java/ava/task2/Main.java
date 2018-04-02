package ava.task2;

import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        KeywordStatisticsInFile statistics = new KeywordStatisticsInFile();
        statistics.parse(Paths.get("java-se-04/src/main/java/ava/task2/fileForTest"), Paths.get("java-se-04/src/main/java/ava/task2/keyWords"));
        for (ava.task1.KeywordStatisticsInFile.KeywordCount keywordCount : statistics.getKeywordCountList()) {
            System.out.printf("%s = %s\n", keywordCount.getKeyword(), keywordCount.getCount());
        }
        statistics.printStatisticIntoTheFile(Paths.get("java-se-04/src/main/java/ava/task2/out"));
    }
}
