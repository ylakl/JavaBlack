package main.multithreading;

import java.util.concurrent.Semaphore;

public class SemaphoreEx {
    public static void main(String[] args) {
        Semaphore callbox = new Semaphore(5);
        Person men = new Person("Миша",callbox);
        Person men1 = new Person("Миша1",callbox);
        Person men2 = new Person("Миша2",callbox);
        Person men3 = new Person("Миша3",callbox);
        Person men4 = new Person("Миша4",callbox);
    }
}

class Person extends Thread{
    String name;
    private Semaphore callbox;

    public Person(String name, Semaphore callbox) {
        this.name = name;
        this.callbox = callbox;
        this.start();
    }

       public void run() {

           try {
               System.out.println(name + " ждет");
               callbox.acquire();
               System.out.println(name + " звонит");
               sleep(2000);
               System.out.println(name + " завершил звонок");
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           finally {
               callbox.release();
           }
       }
}