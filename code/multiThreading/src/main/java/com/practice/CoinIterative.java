package com.practice;

import java.util.*;

/**
 * @author tania.gupta
 * @date 24/07/20
 */
public class CoinIterative {

    public static void main(String[] args) {

        findPossibleCombinations(new int[]{1, 2, 5}, 5);

    }

    private static void findPossibleCombinations(int[] denominations, int target) {

        List<List<Integer>> result = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < denominations.length; i++)
            map.put(denominations[i], i);

        int dp[] = new int[target + 1];

        dp[0] = 1;

        for (int coin : denominations) {

            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < denominations.length; i++)
                list.add(i, 0);

            int sum = 0;
            int index1 = map.get(coin);
            int count1 = list.get(index1);
            count1++;
            list.set(index1, count1);
            for (int j = coin; j <= target; j++) {
                dp[j] += dp[j - coin];

//                if(map.containsKey(j)) {
//                    int index = map.get(coin);
//                    int count = list.get(index);
//                    count++;
//                    list.set(index, count);
//                }
                if (map.containsKey(j - coin)) {
                    int index = map.get(j - coin);
                    int count = list.get(index);
                    count++;
                    list.set(index, count);
                }
            }
            result.add(list);
        }

        System.out.println(result);

    }

}
