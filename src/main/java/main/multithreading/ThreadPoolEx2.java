package main.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolEx2 {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService  executorService = Executors.newScheduledThreadPool(1);

//        for(int i=1; i<=10; i++){
//            executorService.execute(new RunnalbeImpl200());
//        }
        //executorService.schedule(new RunnalbeImpl200(),2,TimeUnit.SECONDS);
//        executorService.scheduleAtFixedRate(new RunnalbeImpl200(),2,1,TimeUnit.SECONDS);
//        Thread.sleep(20000);
        executorService.scheduleWithFixedDelay(new RunnalbeImpl200(),2,1,TimeUnit.SECONDS);
        Thread.sleep(20000);
     executorService.shutdown();
       // executorService.awaitTermination(5,TimeUnit.SECONDS);
        System.out.println("Main stop");
    }
}
class RunnalbeImpl200 implements Runnable{

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
