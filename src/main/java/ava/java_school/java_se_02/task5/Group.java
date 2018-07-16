package ava.java_school.java_se_02.task5;

import java.util.*;

public class Group {
    private String groupName;
    private Discipline discipline;
    private Map<Student, List<Number>> students = new HashMap<>();

    public Group(String groupName, Discipline discipline) {
        this.groupName = groupName;
        this.discipline = discipline;
    }

    public Group(String groupName, Discipline discipline, List<Student> students) {
        this.groupName = groupName;
        this.discipline = discipline;
        for (Student student : students) {
            this.students.put(student, new ArrayList<>());
        }
    }

    public void addStudent(Student student) {
        if (!isStudentContain(student))
            this.students.put(student, new ArrayList<>());
        else {
            System.err.printf("Студент - %s уже есть!", student);
        }
    }

    public void removeStudent(Student student) {
        this.students.remove(student);
    }

    public void putMarkToStudent(Student student, Number mark) {
        if (isStudentContain(student)) {
            if (mark.getClass() == getTypeOfMark()) {
                this.students.get(student).add(mark);
            } else {
                throw new IllegalArgumentException(String.format("Оценка не соотвествует допустимому типу. Ожидается: %s, а полученно %s", getTypeOfMark(), mark.getClass()));
            }
        } else {
            System.err.printf("Студента - %s нет в группе!", student);
        }
    }

    public List<Number> getStudentMarks(Student student) {
        return this.students.get(student);
    }

    public boolean isStudentContain(Student student){
        return this.students.containsKey(student);
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    private Class getTypeOfMark() {
        return this.discipline.getTypeOfScore();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(groupName, group.groupName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupName);
    }

    public String getGroupName() {
        return groupName;
    }
}
