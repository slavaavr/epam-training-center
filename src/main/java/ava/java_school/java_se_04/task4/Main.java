package ava.java_school.java_se_04.task4;

public class Main {
    public static void main(String[] args) {
        FilmsAndActors filmsAndActors = new FilmsAndActors();
        filmsAndActors.addFilms("Зеленая миля", "Реквием по мечте");
        filmsAndActors.addActorsToFilm("Зеленая миля", "Том Хэнкс", "Бонни Хант", "Грэм Грин");
        SerializeObj.writeObj(filmsAndActors, "ava/java_school/java_se_04/task4/filmsAndActors");
        FilmsAndActors filmsAndActors1 = (FilmsAndActors) SerializeObj.readObjFromFile("ava/java_school/java_se_04/task4/filmsAndActors");
        filmsAndActors1.print();
    }
}
