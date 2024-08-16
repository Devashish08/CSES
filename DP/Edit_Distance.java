package DP;
import java.io.*;

public class Edit_Distance {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        String first = reader.readLine();
        String second = reader.readLine();

        int n = first.length();
        int m = second.length();

        int[][] dp = new int[n + 1][m + 1];
        for(int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }

        for(int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                char x = first.charAt(i - 1);
                char y = second.charAt(j - 1);

                if(x == y) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }

                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
            }
        }

        writer.println(dp[n][m]);
        writer.close();
        reader.close();
    }
}
