package ava.task4;

public class Main {
    public static void main(String[] args) {
        FilmsAndActors filmsAndActors = new FilmsAndActors();
        filmsAndActors.addFilms("Зеленая миля", "Реквием по мечте");
        filmsAndActors.addActorsToFilm("Зеленая миля", "Том Хэнкс", "Бонни Хант", "Грэм Грин");
        SerializeObj.writeObj(filmsAndActors, "java-se-04/src/main/java/ava/task4/filmsAndActors");
        FilmsAndActors filmsAndActors1 = (FilmsAndActors) SerializeObj.readObjFromFile("java-se-04/src/main/java/ava/task4/filmsAndActors");
        filmsAndActors1.print();
    }
}
