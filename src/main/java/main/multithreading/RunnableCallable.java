package main.multithreading;

import java.util.concurrent.*;

public class RunnableCallable {
    static int factorialResalt;

    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Factorial factorial = new Factorial(5);
        Future<Integer> future = service.submit(factorial);
        try {
            factorialResalt = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println(e.getCause());
        } finally {
            service.shutdown();
        }
        System.out.println(factorialResalt);
    }
}
class Factorial implements Callable<Integer>{
int f;

    public Factorial(int f) {
        this.f = f;
    }

    @Override
    public Integer call() throws Exception {
        if(f<=0){
            throw new Exception("Вы ввели неверное число");
        }
        int resalt = 1;
        for(int i =1; i<=f; i++){
            resalt*=i;
        }
        return resalt;
    }
}

