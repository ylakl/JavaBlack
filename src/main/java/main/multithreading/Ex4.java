package main.multithreading;

public class Ex4 {
    static volatile int counte = 0;
    public static synchronized void increment(){
        counte++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new R());
        Thread thread1 = new Thread(new R());
        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
        System.out.println(counte);
    }
}
class R implements Runnable{

    @Override
    public void run() {
        for(int i=0; i<1000; i++){
            Ex4.increment();
        }
    }
}