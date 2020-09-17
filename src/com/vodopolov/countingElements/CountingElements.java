package com.vodopolov.countingElements;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Anton on 12.04.2020.
 */
public class CountingElements {
    public static void main(String[] args) {
        CountingElements inst = new CountingElements();
        int[] arr = {1, 2, 3};
        System.out.println(inst.countElements(arr));
        arr = new int[]{1, 1, 3, 3, 5, 5, 7, 7};
        System.out.println(inst.countElements(arr));
        arr = new int[]{1, 3, 2, 3, 5, 0};
        System.out.println(inst.countElements(arr));
        arr = new int[]{1, 1, 2, 2};
        System.out.println(inst.countElements(arr));
    }

    public int countElements(int[] arr) {
        int result = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : arr)
            set.add(i);
        for (int i : arr)
            if (set.contains(i + 1)) result++;
        return result;
    }
}
