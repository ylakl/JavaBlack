package main.nio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx {
    public static void main(String[] args) throws IOException {
        //FileReader reader = null;
        try {
            BufferedReader readerB = new BufferedReader(new FileReader("Stih3.txt"));
//            int c;
//            while ((c = reader.read())!=-1){
//                System.out.println((char)c);
//            };
            String line;
            while ((line = readerB.readLine())!= null){
            System.out.println(line);}
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//        finally {
//            reader.close();
//        }
    }
}
