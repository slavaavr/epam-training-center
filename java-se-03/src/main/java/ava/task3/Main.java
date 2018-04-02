package ava.task3;

public class Main {
    public static void main(String[] args) {
        HtmlParser parser = new HtmlParser();
        parser.parse();
        System.out.println(parser.getSequentialRefToImg());
        System.out.println(parser.isSequentialRefToImg());
        System.out.println(parser.getSentencesWithRefToImg());
    }
}
