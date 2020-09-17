package com.vodopolov.twoSum;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Anton on 28.02.2020.
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 11, 15};
        TwoSum inst = new TwoSum();
        System.out.println(Arrays.toString(inst.twoSum(arr, 9)));
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            if (map.containsKey(result)) return new int[]{map.get(result), i};
            else map.put(nums[i], i);
        }
        return null;
    }
}
