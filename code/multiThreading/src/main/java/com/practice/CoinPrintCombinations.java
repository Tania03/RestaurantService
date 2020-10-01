package com.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tania.gupta
 * @date 29/07/20
 */
public class CoinPrintCombinations {

    public static void main(String[] args) {

        CoinPrintCombinations coinPrintCombinations = new CoinPrintCombinations();
        System.out.println(coinPrintCombinations.printPossibleCombinations(new int[]{1, 2, 5}, 5));

    }

    private List<List<Integer>> printPossibleCombinations(int[] denominations, int target) {

        List<List<Integer>> result = new ArrayList<>();

        helper(target, 0, denominations, new ArrayList<>(), result);

        return result;

    }

    private void helper(int target, int index, int[] denominations, List<Integer> list, List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        if (target < denominations[index])
            return;

        for (int i = index; i < denominations.length; i++) {

            list.add(denominations[i]);
            helper(target - denominations[i], i, denominations, list, result);
            list.remove(list.size() - 1);

        }

    }
}
