package com.CK;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        new Solution().numSquares(48);
    }
}

class Solution {
    public int numSquares(int n) {
        int sq = (int) Math.sqrt(n);
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}

class Solution2 {
    public int numSquares(int n) {
        int level = 0;
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] hash = new boolean[n];
        int sqrt = (int) Math.floor(Math.sqrt(n));
        int[] squares = new int[sqrt + 1];
        for (int i = 0; i <= sqrt; i++) {
            squares[i] = i * i;
        }
        q.add(n);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                int popped = q.poll();
                for (int i = (int) Math.floor(Math.sqrt(popped)); i >= 1; i--) {
                    int diff = popped - squares[i];
                    if (diff == 0) {
                        return level + 1;
                    }
                    if (!hash[diff]) {
                        q.add(diff);
                        hash[diff] = true;
                    }
                }
                size--;
            }
            level++;
        }
        return n;

    }
}