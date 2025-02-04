package main.generic;

import java.util.ArrayList;

public class ParamMetod {
    public static void main(String[] args) {
        ArrayList<Integer> all = new ArrayList<>();
        all.add(2);
        all.add(5);
        int a =  GenMetod.getSecondElement(all);
        System.out.println(a);

        ArrayList<String> allS = new ArrayList<>();
        allS.add("F");
        allS.add("S");
        String as =  GenMetod.getSecondElement(allS);
        System.out.println(as);
    }
}
class GenMetod{
    public static <T> T getSecondElement(ArrayList<T>al){
        return al.get(0);
    }
}