package main.multithreading;

public class WaitNotify {
    private int breadCount = 0;
    //Object lock = new Object();

    public synchronized void putBread() {
       // synchronized (lock) {
            while (breadCount >=5) {
                try {
                    //lock.wait();
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            breadCount++;
            System.out.println("Производитель произвел хлеб");
            System.out.println("Сейчас есть " + breadCount);
            this.notify();
            //lock.notify();
        }
    //}

    public synchronized void getBread() {
        //synchronized (lock) {
        while (breadCount < 1) {
            try {
                //lock.wait();
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        breadCount--;
        System.out.println("Потребитель купил хлеб");
        System.out.println("Сейчас есть " + breadCount);
        //lock.notify();
        this.notify();
    }
//}

    public static void main(String[] args) {
        WaitNotify waitNotify = new WaitNotify();
        Producer producer = new Producer(waitNotify);
        Consumer consumer = new Consumer(waitNotify);
        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(consumer);
        thread1.start();
        thread2.start();
    }
}

class Producer implements Runnable {
    private final WaitNotify waitNotify;

    Producer(WaitNotify waitNotify) {
        this.waitNotify = waitNotify;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            waitNotify.putBread();
        }
    }
}

class Consumer implements Runnable {
    private final WaitNotify waitNotify;

    Consumer(WaitNotify waitNotify) {
        this.waitNotify = waitNotify;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            waitNotify.getBread();
        }
    }
}