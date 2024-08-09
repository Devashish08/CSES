package DP;

import java.io.*;

public class Grid_Path {
    private static final int MOD = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        char[][] grid = new char[n][n];

        for(int i = 0; i < n; i++) {
            String line = reader.readLine();
            grid[i] = line.toCharArray();
        }

        int[][] dp = new int[n][n];

        if(grid[n - 1][n - 1] == '.')
            dp[n - 1][n - 1] = 1;
        else
            dp[n - 1][n - 1] = 0;

        for(int i = n - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                if(i == n - 1 && j == n - 1) {
                    continue;
                }
                if(grid[i][j] == '*'){
                    dp[i][j] = 0;
                } else {
                    int ans1 = i < n - 1 ? dp[i + 1][j] : 0;
                    int ans2 = j < n - 1 ? dp[i][j + 1] : 0;

                    dp[i][j] = (ans1 + ans2) % MOD;
                }
            }
        }

        writer.println(dp[0][0]);
        reader.close();
        writer.close();
    }
}
