package main.nio;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriteEx {
    public static void main(String[] args) throws IOException {
        String p = "В тающей\n" +
                "осенней дрёме\n" +
                "льдинки янтаря.\n" +
                "Всё прозрачней,\n" +
                "невесомей\n" +
                "солнце сентября.\n" +
                "Сонмы бликов,\n" +
                "полутеней\n" +
                "зыбкая купель.\n" +
                "Просветлённое\n" +
                "смятенье.\n" +
                "Листьев\n" +
                "лёгкий хмель.";
        String s = "Автор: Виктор Никифоров Сиринкс";
        try(FileWriter writer = new FileWriter("Stih3.txt", true)) {

//            for(int i = 0; i< p.length(); i++){
//                writer.write(p.charAt(i));
//            }
            writer.write(s);
            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }
//        finally {
//            writer.close();
//        }


    }
}
