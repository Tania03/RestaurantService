package com.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author tania.gupta
 * @date 30/07/20
 */
public class CutRope {

    public static void main(String[] args) {

        CutRope cutRope = new CutRope();
        System.out.println(cutRope.findMaxProfit(new int[]{1, 5, 8, 9, 10, 17, 17, 20}, 4));


    }

    private int findMaxProfit(int[] cost, int length) {

        int dp[] = new int[length + 1];

        dp[0] = 0;

        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= i; j++)
                dp[i] = Math.max(dp[i], cost[j - 1] + dp[i - j]);
        }

        return dp[length];

    }
}
