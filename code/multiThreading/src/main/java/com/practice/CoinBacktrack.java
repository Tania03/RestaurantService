package com.practice;

import java.util.*;

/**
 * @author tania.gupta
 * @date 24/07/20
 */
public class CoinBacktrack {

    static int denCount[];
    static int count = 3;

    public static void main(String[] args) {

        denCount = new int[count];
        System.out.println(findPossibleCombinations(new int[]{1, 2, 3}, 5));

    }

    private static List<List<Integer>> findPossibleCombinations(int[] denominations, int target) {

        List<List<Integer>> result = new ArrayList<>();

        helper(target, 0, denominations, new ArrayList<>(), result);

        return result;
    }

    private static void helper(int target, int index, int[] denominations,
                               List<Integer> list, List<List<Integer>> result) {

        if (target == 0) {
            List list1 = new ArrayList();
            for (int i : denCount)
                list1.add(i);

            result.add(new ArrayList<>(list1));
            return;
        }

        if (target < denominations[index])
            return;

        for (int i = index; i < denominations.length; i++) {

            int count = denCount[i];
            denCount[i]++;
            helper(target - denominations[i], i, denominations, list, result);
            denCount[i] = count;
        }

    }
}

