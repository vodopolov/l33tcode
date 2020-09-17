package com.vodopolov.coinChange;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Anton on 06.03.2020.
 */
public class CoinChange {
    public static void main(String[] args) {
        CoinChange inst = new CoinChange();
        System.out.println(inst.coinChange(new int[]{484, 395, 346, 103, 329}, 4259));
    }

    public int coinChange(int[] coins, int amount) {
        int[] paths = new int[amount + 1];
        Arrays.fill(paths, amount + 1);
        Arrays.sort(coins);
        paths[0] = 0;
        for (int i = 1; i < paths.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] > i) break;
                paths[i] = Math.min(paths[i], 1 + paths[i - coins[j]]);
            }
        }
        return paths[amount] > amount ? -1 : paths[amount];
    }
}
