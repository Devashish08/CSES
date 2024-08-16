package DP;

import java.io.*;

public class Rectangle_Cutting {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        String[] line = reader.readLine().split(" ");
        int n = Integer.parseInt(line[ 0 ]);
        int m = Integer.parseInt(line[ 1 ]);

        int[][] dp = new int[ n + 1 ][ m + 1 ];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == j) {
                    dp[ i ][ j ] = 0;
                    continue;
                } else {
                    dp[ i ][ j ] = 1000000007;
                    for (int k = 1; k < i; k++) {
                        dp[ i ][ j ] = Math.min(dp[ i ][ j ], dp[ k ][ j ] + dp[ i - k ][ j ] + 1);
                    }

                    for (int k = 1; k < j; k++) {
                        dp[ i ][ j ] = Math.min(dp[ i ][ j ], dp[ i ][ k ] + dp[ i ][ j - k ] + 1);
                    }
                }
            }
        }

        writer.println(dp[ n ][ m ]);
        writer.close();
        reader.close();
    }
}
