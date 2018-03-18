package main.ava.task5;

public enum Discipline {
    MATH(Double.class),
    PHYSICS(Double.class),
    ART(Integer.class),
    ENGLISH_LITERATURE(Integer.class);

    private Class typeOfScore;
    Discipline(Class typeOfScore) {
        this.typeOfScore = typeOfScore;
    }

    public Class getTypeOfScore() {
        return typeOfScore;
    }

}
