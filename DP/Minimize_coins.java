package DP;

import java.io.*;
import java.util.*;

public class Minimize_coins {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));

        String[] inputs = reader.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int x = Integer.parseInt(inputs[1]);

        int[] arr = new int[n];
        String[] arrInput = reader.readLine().split(" ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(arrInput[i]);
        }

        int[] dp = new int[x + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= x; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[j] <= i && dp[i - arr[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - arr[j]] + 1);
                }
            }
        }

        if (dp[x] != Integer.MAX_VALUE) {
            writer.println(dp[x]);
        } else {
            writer.println(-1);
        }

        writer.flush();
    }
}