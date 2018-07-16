package ava.java_se_03.task2;

import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose language: ");
        System.out.println("1. RUS");
        System.out.println("2. EN");
        System.out.print("> ");
        int ans;
        ResourceProperty res;
        ans = scanner.nextInt();
        if (ans == 1) {
            res = new ResourceProperty(new Locale("ru"));
        } else if (ans == 2) {
            res = new ResourceProperty(new Locale("en"));
        } else res = new ResourceProperty(Locale.getDefault());
        Map<Integer, ResourceProperty.QA> intQAMap = res.makeQAMap();
        while(true){
            for (Integer key : intQAMap.keySet()) {
                System.out.printf("%d. %s\n", key, intQAMap.get(key).question);
            }
            System.out.println("0. Exit");
            System.out.print("> ");
            ans = scanner.nextInt();
            if (ans == 0) {
                break;
            }
            if(intQAMap.containsKey(ans)){
                System.out.printf("Answer: %s\n", intQAMap.get(ans).answer);
            }
        }
    }
}
