package ava.java_school.java_se_01;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Task6 {
    public static void main(String[] args) {
        Notebook notebook = new Notebook();
        notebook.add(new Note("Купить хлеб"));
        notebook.add(new Note("Купить молоко"));
        notebook.add(new Note("Купить чай"));
        notebook.remove(new Note("Купить чай"));
        notebook.edit(new Note("Купить хлеб"), new Note("Купить хлеб и масло"));
        notebook.show();
    }
}

/**
 * class Notebook - представляет блокнот
 */
class Notebook{
    /**
     * notes - массив записей, который может храниться в блокноте
     */
    private List<Note> notes;

    public Notebook(){
        notes = new ArrayList<>();
    }

    /**
     * Функция добавляет запись в блокнот
     * @param note - запись
     */
    public void add(Note note){
        this.notes.add(note);
    }

    /**
     * Функция удаляет запись из блокнота
     * @param note - запись
     */
    public void remove(Note note){
        if(!this.notes.remove(note)){
            System.err.println("Запись " + note + " не была найдена!");
        }
    }

    /**
     * Функция позволяет редактировать запись
     * @param oldNote - старая запись
     * @param newNote - новая запись
     */
    public void edit(Note oldNote, Note newNote){
        this.notes.remove(oldNote);
        this.notes.add(newNote);
    }

    /**
     * Печать содержимого блокнота
     */
    public void show(){
        this.notes.forEach(System.out::println);
    }
}

/**
 * class Note - представляет запись
 */
class Note{
    /**
     * content - содержимое записи
     */
    private String content;

    public Note(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Note{" +
                "content='" + content + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return Objects.equals(content, note.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }
}