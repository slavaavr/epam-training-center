package ava.task3;

import java.util.Random;

public class IntegerSetterGetter extends Thread {
    private SharedResource resource;
    private boolean run;
    private Random rand = new Random();

    public IntegerSetterGetter(String name, SharedResource resource) {
        super(name);
        this.resource = resource;
        run = true;
    }

    public void stopThread() {
        run = false;
    }

    @Override
    public void run() {
        int action;

        try {
            while (run) {
                action = rand.nextInt(1000);
                if (action % 2 == 0) {
                    getIntegersFromResource();
                } else {
                    setIntegersIntoResource();
                }
            }

            System.out.printf("Поток %s завершил работу.\n", getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void getIntegersFromResource() throws InterruptedException {
        Integer number;
        int counter = 0;
        synchronized (resource) {
            System.out.printf("Поток %s хочет извлечь число.\n", getName());
            number = resource.getElement();
            while (number == null) {
                System.out.printf("Поток %s ждет пока очередь заполнится.\n", getName());
                resource.wait(100);
                counter++;
                System.out.printf("Поток %s возобновил работу.\n", getName());
                number = resource.getElement();
                if (counter > 9)
                    break;
            }
            System.out.printf("- Поток %s извлёк число %s.\n", getName(), number);
        }
    }

    private void setIntegersIntoResource() {
        Integer number = rand.nextInt(500);
        synchronized (resource) {
            resource.setElement(number);
            System.out.printf("+ Поток %s записал число %s.\n", getName(), number);
            resource.notifyAll();
        }
    }
}