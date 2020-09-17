package com.vodopolov.maximumSubarray;

/**
 * Created by Anton on 05.03.2020.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int[] maximums = new int[nums.length];
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) maximums[i] = nums[i];
            else maximums[i] = maximums[i - 1] + nums[i] > nums[i] ? maximums[i - 1] + nums[i] : nums[i];

            result = Math.max(result, maximums[i]);
        }

        return result;
    }
}
