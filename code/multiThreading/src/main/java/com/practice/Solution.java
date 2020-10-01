package com.practice;

import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


class Result {

    /*
     * Complete the 'countPrimeStrings' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    static int MOD = 1000000007;
    public static boolean[] sieve = new boolean[1000000];

    public static void buildSieve() {

        Arrays.fill(sieve, true);

        sieve[0] = false;
        sieve[1] = false;

        for (int p = 2; p * p <= 1000000; p++) {

            if (sieve[p] == true) {
                for (int i = p * p; i < 1000000; i += p) {
                    sieve[i] = false;
                }
            }
        }

    }

    public static boolean isPrime(String s) {
        int num = Integer.valueOf(s);
        return sieve[num];
    }

    public static int countPrimeStrings(String s) {
        // Write your code here

        buildSieve();

        int len = s.length();

        int dp[] = new int[len + 1];
        Arrays.fill(dp, -1);

        dp[0] = 1;

        return countWays(s, len, dp);
    }

    public static int countWays(String s, int i, int dp[]) {

        if (dp[i] != -1)
            return dp[i];

        int count = 0;

        for (int j = 1; j <= 6; j++) {

            if (i - j >= 0
                    && s.charAt(i - j) != '0'
                    && isPrime(s.substring(i - j, i))) {

                count += countWays(s, i - j, dp);
                count %= MOD;
            }
        }

        return dp[i] = count;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random(0);

        String s = sc.next();
        System.out.println(Result.countPrimeStrings(s));

    }
}
