package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Two_Sets {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int mod = 1000000007;
        int n = Integer.parseInt(br.readLine());
        int target = n * (n + 1) / 2;

        if (target % 2 != 0) {
            out.println(0);
            out.flush();
            return;
        }

        target /= 2;

        // Create a 2D DP array with dimensions (n x (target + 1))
        int[][] dp = new int[n][target + 1];
        dp[0][0] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                int left = j - i;
                if (left >= 0) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][left]) % mod;
                }
            }
        }

        out.println(dp[n - 1][target]);
        out.flush();
        out.close();
    }
}