//package DP;
//
//import java.io.*;
//
//public class Coin_Combinations2 {
//    private static final int MOD = 1000000007;
//    public static void main(String[] args) throws Exception {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter wr = new PrintWriter(new OutputStreamWriter(System.out));
//
//        String[] line = reader.readLine().split(" ");
//        int n = Integer.parseInt(line[ 0 ]);
//        int m = Integer.parseInt(line[ 1 ]);
//
//        int[] arr = new int[ n ];
//        String[] arrInput = reader.readLine().split(" ");
//
//        for(int i = 0; i < n; i++) {
//            arr[i] = Integer.parseInt(arrInput[i]);
//        }
//
//        int[][] dp = new int[n + 1][m + 1];
//
//        for(int i = 0; i < n; i++) {
//            dp[i][0] = 1;
//        }
//
//        for(int i = n - 1; i >= 0; i--) {
//            for(int sum = 1; sum <= m; sum++) {
//                int skip = dp[i + 1][sum];
//                int picked = 0;
//                if(arr[i] <= sum) {
//                    picked = dp[i][sum - arr[i]];
//                }
//
//                dp[i][sum] = (skip + picked) % MOD;
//            }
//        }
//
//        wr.println(dp[0][m]);
//        wr.flush();
//    }
//}

package DP;

import java.io.*;

public class Coin_Combinations2 {
    private static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int x = Integer.parseInt(input[1]);
        input = reader.readLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(input[i]);
        }

        // dp[i][k] = number of ways to construct sum k
        // such that all coins before coin[i] are unusable

        // dp[i][k] -> dp[i + 1][k], dp[i][k - ci]

        int[] nextState = new int[x + 1];
        nextState[0] = 1; // dp[n][0] = 1;

        for (int i = n - 1; i >= 0; i--) {
            int[] currentState = new int[x + 1];
            currentState[0] = 1;
            for (int sum = 1; sum <= x; sum++) {
                int skipping = nextState[sum];
                int picking = 0;
                if (a[i] <= sum) {
                    picking = currentState[sum - a[i]];
                }
                currentState[sum] = (skipping + picking) % MOD;
            }
            // currentState[k] = dp[i][k]
            // nextState[k] = dp[i + 1][k]
            nextState = currentState;
        }
        System.out.println(nextState[x]);
    }
}