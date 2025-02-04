package main;

import java.util.ArrayList;
import java.util.Random;

public class RandomNumbers {
    private static Random generator = new Random();

    public static int nextInt(int low, int high) {
        return low + generator.nextInt(high - low + 1);
        // Ok to access the static generator variable
    }

    public static int randomElement(int[] t) {
        if (t.length < 0) {
            int i = generator.nextInt(t.length);
            return t[i];
        } else {
            return 0;
        }
    }
    public static int randomElement(ArrayList<Integer> t) {
        if (t.size() < 0) {
            int i = generator.nextInt(t.size());
            return t.get(i);
        } else {
            return 0;
        }
    }
}
