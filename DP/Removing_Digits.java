package DP;

import java.io.*;
import java.util.*;

public class Removing_Digits {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        for(int i = 1; i <= n; i++) {
            String s = Integer.toString(i);
            for (char c : s.toCharArray()) {
                int digit = c - '0';
                if (digit != 0) {
                    dp[ i ] = Math.min(dp[ i ], dp[ i - digit ] + 1);
                }
            }
        }
        writer.println(dp[n]);
        writer.flush();
    }
}
