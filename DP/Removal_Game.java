package DP;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Removal_Game {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());
        int[] x = new int[n];
        long sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            x[i] = Integer.parseInt(st.nextToken());
            sum += x[i];
        }

        long[][] dp = new long[n][n];

        for (int l = n - 1; l >= 0; l--) {
            for (int r = l; r < n; r++) {
                if (l == r) {
                    dp[l][r] = x[l];
                } else {
                    dp[l][r] = Math.max(x[l] - dp[l + 1][r], x[r] - dp[l][r - 1]);
                }
            }
        }

        out.println((sum + dp[0][n - 1]) / 2);
        out.flush();
        out.close();
    }
}
