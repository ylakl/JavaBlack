package main.multithreading;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolEx1 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for(int i=1; i<=10; i++){
            executorService.execute(new RunnalbeImpl100());
        }
        executorService.shutdown();
        executorService.awaitTermination(5,TimeUnit.SECONDS);
        System.out.println("Main stop");
    }
}
class RunnalbeImpl100 implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "end");
    }
}