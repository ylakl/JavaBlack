package main.multithreading;

import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;

public class CountDounLatchEx {
    static CountDownLatch countDownLatch = new CountDownLatch(3);
    private static void comeMarket() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Пришли");
        countDownLatch.countDown();
        System.out.println(" countDownLatch "+countDownLatch.getCount() );
    }
    private static void getMarket() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Подготовились");
        countDownLatch.countDown();
        System.out.println(" countDownLatch "+countDownLatch.getCount() );
    }
    private static void openMarket() throws InterruptedException {
        Thread.sleep(4000);
        System.out.println("Открылись");
        countDownLatch.countDown();
        System.out.println(" countDownLatch "+countDownLatch.getCount() );
    }
    public static void main(String[] args) throws InterruptedException {
        Friends friends = new Friends("Маня",countDownLatch);
        Friends friends1 = new Friends("Маня1",countDownLatch);
        Friends friends2 = new Friends("Маня2",countDownLatch);
        comeMarket();
        getMarket();
        openMarket();

    }
}
class Friends extends Thread{
    String name;
    CountDownLatch countDownLatch;

    public Friends(String name, CountDownLatch countDownLatch) {
        this.name = name;
        this.countDownLatch = countDownLatch;
        this.start();
    }

        @SneakyThrows
        public void run() {
            try {
                countDownLatch.await();
                System.out.println("Началась жаришка");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
}