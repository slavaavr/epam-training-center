package ava.java_se_02.task6;

import ava.java_se_02.task7.EnableAnnotationInJavaDoc;

@EnableAnnotationInJavaDoc("enable annotation in java doc")
public class AtomicBoat {
    private double boatLength;
    private double boatHeight;
    private Engine engine;

    public AtomicBoat(double boatLength, double boatHeight, Engine engine) {
        this.boatLength = boatLength;
        this.boatHeight = boatHeight;
        this.engine = engine;
    }

    public AtomicBoat(double boatLength, double boatHeight) {
        this.boatLength = boatLength;
        this.boatHeight = boatHeight;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void goSwimming(){
        if(engine != null){
            System.out.println("Выход в плавание...");
        } else {
            throw new IllegalStateException("Требуется установить двигатель!");
        }
    }

    @Override
    public String toString() {
        return "AtomicBoat{" +
                "boatLength=" + boatLength +
                ", boatHeight=" + boatHeight +
                ", engine=" + engine +
                '}';
    }

    static class Engine {
        private String modelOfEngine;

        public Engine(String modelOfEngine) {
            this.modelOfEngine = modelOfEngine;
        }

        public String getModelOfEngine() {
            return modelOfEngine;
        }

        public void setModelOfEngine(String modelOfEngine) {
            this.modelOfEngine = modelOfEngine;
        }

        @Override
        public String toString() {
            return "Engine{" +
                    "modelOfEngine='" + modelOfEngine + '\'' +
                    '}';
        }
    }
}
