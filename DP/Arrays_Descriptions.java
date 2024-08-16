package DP;
import java.io.*;

public class Arrays_Descriptions {
    private static final int MOD = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int x = Integer.parseInt(input[1]);

        int[] val = new int[n];

        input = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            val[i] = Integer.parseInt(input[i]);
        }
        int[][] dp = new int[n + 1][x + 1];

        // Base case initialization
        for(int i = 1; i <= x; i++) {
            if(val[0] == i || val[0] == 0) {
                dp[1][i] = 1; // Fix here
            }
        }

        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= x; j++) {
                if(val[i - 1] != 0 && val[i - 1] != j) {
                    dp[i][j] = 0;
                    continue;
                }

                for(int prev = j - 1; prev <= j + 1; prev++) {
                    if(!valid(prev, x)) {
                        continue;
                    }
                    dp[i][j] = (dp[i][j] + dp[i - 1][prev]) % MOD;
                }
            }
        }

        int ans = 0;
        for(int i = 1; i <= x; i++) {
            ans = (ans + dp[n][i]) % MOD;
        }

        writer.println(ans);
        writer.close();
        reader.close();
    }

    private static boolean valid(int x, int m) {
        return x >= 1 && x <= m;
    }
}
