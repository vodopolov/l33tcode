package com.vodopolov.singleNumber;

/**
 * Created by Anton on 16.02.2020.
 */
public class SingleNumber {
    public static void main(String[] args) {
        SingleNumber inst = new SingleNumber();
        System.out.println(inst.singleNumber(new int[]{4, 1, 2, 1, 2}));
    }

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}
