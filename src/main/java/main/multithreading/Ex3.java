package main.multithreading;

public class Ex3 extends Thread{
   public void run() {
       for (int v = 0; v <= 5; v++){
           try {
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           System.out.println(Thread.currentThread().getName() + " " + v );

       }   }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Thread2());
        Ex3 ex3 = new Ex3();
        thread.start();
        ex3.start();
        thread.join();
        ex3.join();
        System.out.println("Конец!!!");
    }


}
class Thread2 implements Runnable {

    @Override
    public void run() {
        for (int v = 0; v <= 5; v++){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + v );

        }
    }
}