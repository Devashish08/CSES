package DP;
import java.util.*;
import java.io.*;

public class Dice_Combination {
    private static final int MOD = 1000000007;
    private static void solve() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        int n = Integer.parseInt(reader.readLine());

        int[] dp = new int[n + 1];

        dp[0] = 1;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(j <= i) {
                    dp[i] = (dp[i] + dp[ i - j]) & MOD;
                }
            }
        }

        writer.println(dp[n]);
        writer.flush();
    }

    private static void solve1() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        int n = Integer.parseInt(reader.readLine());

        int[] dp = new int[n + 1];

        dp[n] = 1;

        for(int i = n - 1; i >= 0; i--) {
            for(int j = 1; j <= 6; j++) {
                if(j <= n - i) {
                    dp[i] = (dp[i] + dp[i + j]) % MOD;
                }
            }
        }

        writer.println(dp[0]);
        writer.flush();
    }

    private static void solve2() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        int n = Integer.parseInt(reader.readLine());

        List<Integer> list = new ArrayList<>();
        list.add(1);

        for(int i = 1; i <= n; i++) {
            int current = 0;
            for(int j : list) {
                current = (current + j) % MOD;
            }
            list.add(current);

            if(list.size() > 6) {
                list.remove(0);
            }
        }

        writer.println(list.get(list.size() - 1));
        writer.flush();
    }

    private static void solve3() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        int n =  Integer.parseInt(reader.readLine());

        int[] dp = new int[n + 1];

        dp[0] = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= 6 && i - j >= 0; j++) {
                dp[i] = (dp[i] + dp[i - j]) % MOD;
            }
        }

        writer.println(dp[n]);
        writer.flush();

    }

    private static void solve4() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        List<Integer> prev = new ArrayList<Integer>();
        prev.add(1);

        for(int i = 1; i <= n; i++) {
            int current = 0;
            for(int j : prev) {
                current = (current + j) % MOD;
            }

            prev.add(current);

            if(prev.size() > 6) {
                prev.remove(current);
            }
        }

        writer.println(prev.get(prev.size() - 1));
        writer.flush();

    }

    public static void main(String[] args) throws Exception {
//        solve();
//        solve1();
//        solve2();
        solve3();
    }
}