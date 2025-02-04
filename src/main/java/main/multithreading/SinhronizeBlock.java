package main.multithreading;

public class SinhronizeBlock {
    private static Object lock = new Object();
    void mobileCall(){
        synchronized (lock){
        System.out.println("mobileCall Start");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("mobileCall Stop");
    }}
    void skipeCall(){
        synchronized (lock){
        System.out.println("skipeCall Start");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("skipeCall Stop");
    }}
    void viberCall(){
            synchronized (lock){

        System.out.println("viberCall Start");
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("viberCall Stop");
    }
    }
    public static void main(String[] args) {
        Thread thread1 = new Thread(new RunnableImplMobile());
        Thread thread2 = new Thread(new RunnableImplSkipe());
        Thread thread3 = new Thread(new RunnableImplViber());
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
class RunnableImplMobile implements Runnable{

    @Override
    public void run() {
        new SinhronizeBlock().mobileCall();
    }
}
class RunnableImplViber implements Runnable{

    @Override
    public void run() {
        new SinhronizeBlock().viberCall();
    }
}
class RunnableImplSkipe implements Runnable{

    @Override
    public void run() {
        new SinhronizeBlock().skipeCall();
    }
}