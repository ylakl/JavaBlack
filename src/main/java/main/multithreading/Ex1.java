package main.multithreading;

public class Ex1 {
    public static void main(String[] args) {
        Thread myThread1 = new Thread(new MyThread3());
        new Thread(() -> {
            for (int i = 100; i> 0; i--){
                System.out.println("MyThread4 " + i);}
        }).start();
        myThread1.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
               System.out.println("PRIVET&&&&&&&&&&&&&&&&&&&&&&");
            }
        }).start();
    }
}
class MyThread3 implements Runnable {
    public void run(){
        for (int i = 1; i<=100; i++){
            System.out.println("MyThread3 " + i);}
    }
}
class MyThread4 implements Runnable{
    public void run(){
        for (int i = 100; i> 0; i--){
            System.out.println("MyThread4" + i);}
    }
}
