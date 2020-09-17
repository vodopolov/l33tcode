package com.vodopolov.sum3Closest;

import java.util.Arrays;

/**
 * Created by Anton on 23.02.2020.
 */
public class Sum3Closest {
    public static void main(String[] args) {
        int[] array = {-1, 2, 1, -4};
        Sum3Closest inst = new Sum3Closest();
        System.out.println(inst.threeSumClosest(array, 1));
    }

    public int threeSumClosest(int[] nums, int target) {
        int currentClosest = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int currentSum = nums[i] + nums[start] + nums[end];

                if (currentSum == target) return target;
                if (currentSum > target) end--;
                else start++;

                if (Math.abs(currentSum - target) < Math.abs(currentClosest - target)) currentClosest = currentSum;
            }
        }
        return currentClosest;
    }
}
