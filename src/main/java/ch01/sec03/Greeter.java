package ch01.sec03;

import java.io.File;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Greeter implements Runnable {
    int n;
    String target;

    public Greeter(int n, String target) {
        this.n = n;
        this.target = target;
    }

    @Override
    public void run() {
        for(int i =0; i<n; i++){
      System.out.println("Hello " + target);  }
    }
    public static void runTogether(Runnable... task){
for(Runnable runnable: task){
    Thread thread = new Thread(runnable);
    thread.start();
}
    }
public static File[] filterFile(String s, String path) {
        File file = new File(path);
        if (file.isDirectory()){
            return file.listFiles(x -> x.getName().startsWith(s));
        } else {
            System.out.println("Это не каталог");
            return null;
        }
    }
    public static String[] filterFiles(String s, String path) {
        File file = new File(path);
        if (file.isDirectory()){
            return file.list((dir,x) -> x.endsWith(s));
        } else {
            System.out.println("Это не каталог");
            return null;
        }
    }
    public static void Sorted(String path){
        File file = new File(path);
     File[] filts = file.listFiles();
        Arrays.sort(filts,(x,y)-> {
            if(x.isDirectory() && y.isFile())return -1 ;
            if(x.isDirectory() && y.isDirectory())return 0 ;
            if(x.isFile() && y.isDirectory())return 1 ; ;
        return 0;});
        for (File f : filts) {
          System.out.println(f.getName());
        }
    }
    public static Runnable ran (Runnable[] runnables) {
        return () -> {
        for (Runnable r: runnables) {
          r.run();
        }};
    }
}
