package com.vodopolov.twoSumLessThanK;

/**
 * Created by Anton on 17.02.2020.
 */
public class TwoSumLessThanK {
    public static void main(String[] args) {
        int[] array = {10, 20, 30};
        TwoSumLessThanK inst = new TwoSumLessThanK();
        System.out.println(inst.twoSumLessThanK(array, 15));
    }

    public int twoSumLessThanK(int[] A, int K) {
        int max = -1;
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if ((A[i] + A[j]) > max && (A[i] + A[j]) < K)
                    max = A[i] + A[j];
            }
        }
        return max;
    }
}
