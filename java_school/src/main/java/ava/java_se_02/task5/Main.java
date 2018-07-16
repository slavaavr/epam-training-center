package ava.java_se_02.task5;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student johnDoe = new Student("John", "Doe");
        Student pollRoberts = new Student("Poll", "Roberts");
        Student aliceGreen = new Student("Alice", "Green");
        Group mathGroup = new Group("g4432", Discipline.MATH);
        Group artGroup = new Group("g4431", Discipline.ART);
        Group engGroup = new Group("g4411", Discipline.ENGLISH_LITERATURE);
        List<Group> groups = Arrays.asList(mathGroup, artGroup, engGroup);
        mathGroup.addStudent(johnDoe);
        mathGroup.addStudent(aliceGreen);
        artGroup.addStudent(pollRoberts);
        artGroup.addStudent(aliceGreen);
        engGroup.addStudent(johnDoe);
        mathGroup.putMarkToStudent(johnDoe, 7.6);
        mathGroup.putMarkToStudent(johnDoe, 7.7);
        engGroup.putMarkToStudent(johnDoe, 8);
        mathGroup.putMarkToStudent(aliceGreen, 8.0);
        artGroup.putMarkToStudent(pollRoberts, 8);
        artGroup.putMarkToStudent(aliceGreen, 9);

       printInfoAbout(johnDoe, groups);
    }
    public static void printInfoAbout(Student student, List<Group> groups) {
        System.out.println(student);
        for (Group group : groups) {
            if (group.isStudentContain(student)) {
                System.out.printf("Группа: %s Предмет: %s\n", group.getGroupName(), group.getDiscipline().name());
                System.out.print("Оценки: ");
                group.getStudentMarks(student).forEach(mark -> System.out.print(mark + " "));
                System.out.println();
            }
        }
    }
}
