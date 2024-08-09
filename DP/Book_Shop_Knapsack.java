//package DP;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//
//public class Book_Shops_Knapsack {
//    public static void main(String[] args) throws Exception {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter writer = new PrintWriter(System.out);
//
//        String[] input = reader.readLine().split(" ");
//        int n = Integer.parseInt(input[0]);
//        int x = Integer.parseInt(input[1]);
//
//        int[] weight = new int[n];
//        int[] val = new int[n];
//
//        input = reader.readLine().split(" ");
//        for (int i = 0; i < n; i++) {
//            weight[i] = Integer.parseInt(input[i]);
//        }
//
//        input = reader.readLine().split(" ");
//        for (int i = 0; i < n; i++) {
//            val[i] = Integer.parseInt(input[i]);
//        }
//
//        int[] prev = new int[x + 1];
//
//        for (int i = 1; i <= n; i++) {
////            dp[i][j] = current[j];
////            dp[i - 1][j] = prev[j];
//            int[] curr = new int[x + 1];
//            for (int j = 0; j <= x; j++) {
//                int w = weight[i - 1];
//                int value = val[i - 1];
//
//                int pick = (j >= w) ? prev[j - w] + value : 0;
//                int skip = prev[j];
//
//                curr[j] = Math.max(skip, pick);
//            }
//            prev = curr;
//        }
//
//        writer.println(prev[x]);
//        writer.close();
//        reader.close();
//    }
//}
//
//

package DP;

import java.io.*;

public class Book_Shop_Knapsack {
    //    private static final int MOD = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));

        String[] line = reader.readLine().split(" ");
        int n = Integer.parseInt(line[ 0 ]);
        int x = Integer.parseInt(line[ 1 ]);
        String[] weightInput = reader.readLine().split(" ");
        String[] arrInput = reader.readLine().split(" ");
        int[] values = new int[ n ];
        int[] weight = new int[ n ];
        for (int i = 0; i < n; i++) {
            weight[ i ] = Integer.parseInt(weightInput[ i ]);
        }
        for (int i = 0; i < n; i++) {
            values[ i ] = Integer.parseInt(arrInput[ i ]);
        }
        int[][] dp = new int[ n + 1 ][ x + 1 ];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= x; j++) {
                int w = weight[ i - 1 ];
                int value = values[ i - 1 ];

                if (w <= j) {
                    dp[ i ][ j ] = Math.max(dp[ i - 1 ][ j ], dp[ i - 1 ][ j - w ] + value);
                } else {
                    dp[ i ][ j ] = dp[ i - 1 ][ j ];
                }
            }
        }

        writer.println(dp[ n ][ x ]);
        reader.close();
        writer.close();
    }
}