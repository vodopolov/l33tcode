package com.vodopolov.happyNumber;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Anton on 02.04.2020.
 */
public class HappyNumber {
    Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        HappyNumber hn = new HappyNumber();
        System.out.println(hn.isHappy(12));
    }

    public boolean isHappy(int n) {
        if (set.contains(n)) return false;
        set.add(n);
        if (n == 1) return true;
        ArrayList<Integer> list = new ArrayList<>();
        do {
            int lastNumber = n % 10;
            n *= 0.1;
            list.add(lastNumber);
        } while (n > 0);
        int result = 0;
        for (Integer item : list) result += Math.pow(item, 2);
        try {
            return isHappy(result);
        } catch (StackOverflowError e) {
            return false;
        }
    }
}
