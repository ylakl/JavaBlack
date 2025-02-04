package main.generic;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<?> list = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(5);
        list2.add(6);
        list2.add(8);
        showList(list2);
        List<? extends Number> list3 = new ArrayList<Integer>();
        System.out.println(summer(list2));
        List<Double> list4 = new ArrayList<Double>();
        list4.add(5.6);
        list4.add(6.7);
        list4.add(8.2);
        System.out.println(summer(list4));
    }
    public static void showList(List<?> list){
        System.out.println("Мой массив содержит эементы "+list);
    };
    public static Double summer(List<? extends Number> list){
        Double summer = 0d;
        for (Number i: list){
            summer+=i.doubleValue();
        }
        return summer;
    };
}
