package DP;

import java.io.*;
import java.util.*;

public class Coin_Combinations {
    private static final int MOD = 1000000007;
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
        dp[0] = 1;

        for(int i  = 1; i <= x; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[j] <= i) {
                    dp[i] = (dp[i] + dp[ i - arr[j]]) % MOD;
                }
            }
        }

        writer.println(dp[x]);

        writer.flush();
    }
}