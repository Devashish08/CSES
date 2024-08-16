package DP;
import java.io.*;
import java.util.*;
public class Money_Sums {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        String[] line = reader.readLine().split(" ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(line[i]);
        }
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += arr[i];
        }
        boolean[][] dp = new boolean[n + 1][sum + 1];
        dp[0][0] = true;

        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= sum; j++){
                if(dp[i - 1][j]){
                    dp[i][j] = true;
                } else {
                    if(j >= arr[i - 1]){
                        dp[i][j] = dp[i - 1][j - arr[i - 1]];
                    }
                }
            }
        }

        List<Integer> sums = new ArrayList<>();
        for(int i = 1; i <= sum; i++){
            if(dp[n][i]){
                sums.add(i);
            }
        }

        writer.println(sums.size());
        for(int i = 0; i < sums.size(); i++){
            writer.print(sums.get(i) + " ");
        }
        writer.close();
        reader.close();
    }

}
