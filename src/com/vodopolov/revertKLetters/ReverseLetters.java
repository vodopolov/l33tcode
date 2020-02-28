package com.vodopolov.revertKLetters;

/**
 * Created by Anton on 25.02.2020.
 */
public class ReverseLetters {
    public static void main(String[] args) {
        ReverseLetters inst = new ReverseLetters();
        System.out.println(inst.reverseStr("abcdef", 3));
//        System.out.println(inst.reverseStr("a", 2));
    }

    public String reverseStr(String s, int k) {
        char[] array = s.toCharArray();
        for (int left = 0; left < s.length(); left += 2 * k) {
            for (int i = left, j = Math.min(i + k - 1, s.length() - 1); j > i;  i++, j--) {
                array[i] += array[j];
                array[j] = (char) (array[i] - array[j]);
                array[i] = (char) (array[i] - array[j]);
            }
        }
        return new String(array);
    }
}
