package main.multithreading;

import main.Employe;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockBankomat {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        new Employee("Yula", lock);
        new Employee("Yula1", lock);
        new Employee("Yula2", lock);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Employee("Yula3", lock);
        new Employee("Yula4", lock);
    }

}

class Employee extends Thread {
    String name;
    private Lock lock;

    public Employee(String name, Lock lock) {
        this.name = name;
        this.lock = lock;
        this.start();
    }

    public void run() {
        if (lock.tryLock()) {
            try {
                //System.out.println(name + " ждет...");
                //lock.lock();
                System.out.println(name + " пользуется");

                Thread.sleep(2000);
                System.out.println(name + " закончила");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println(name + " ушла");
        }
    }
}