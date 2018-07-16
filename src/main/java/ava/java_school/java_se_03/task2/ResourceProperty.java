package ava.java_school.java_se_03.task2;

import java.util.*;
import java.util.stream.Collectors;

public class ResourceProperty {
    private ResourceBundle bundle;
    private static final String FILE_NAME = "src/main/java/ava/java_school/java_se_03/task2/questions";
    private Map<Integer, QA> questionAnswerMap;

    public ResourceProperty(Locale locale) {
        bundle = ResourceBundle.getBundle(FILE_NAME, locale, new UTF8Control());
        questionAnswerMap = new TreeMap<>();
    }

    public List<String> getKeys() {
        return Collections.list(bundle.getKeys());
    }

    public Map<Integer, QA> makeQAMap() {
        QA tempQA;
        Integer index;
        for (String s : getQuestions()) {
            index = Integer.valueOf(s.substring(0, s.indexOf(".")));
            tempQA = new QA();
            tempQA.question = bundle.getString(s);
            questionAnswerMap.put(index, tempQA);
        }
        for (String s : getAnswers()) {
            index = Integer.valueOf(s.substring(0, s.indexOf(".")));
            questionAnswerMap.get(index).answer = bundle.getString(s);
        }
        return questionAnswerMap;
    }

    private List<String> getQuestions() {
        return Collections.list(bundle.getKeys()).stream()
                .filter(s -> s.contains("question"))
                .collect(Collectors.toList());
    }

    private List<String> getAnswers() {
        return Collections.list(bundle.getKeys()).stream()
                .filter(s -> s.contains("answer"))
                .collect(Collectors.toList());
    }

    public static class QA {
        String question;
        String answer;
    }
}
