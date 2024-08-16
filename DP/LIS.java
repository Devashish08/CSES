package DP;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LIS {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }

//        int[] dp = new int[n];
//        Arrays.fill(dp,1);
//        int max = 1;
//
//        for(int i = 1; i < n; i++) {
//            for(int j = 0; j < i; j++) {
//                if(arr[i] > arr[j]) {
//                    dp[ i ] = Math.max(dp[ i ], dp[ j ] + 1);
//                }
//            }
//            max = Math.max(max, dp[ i ]);
//        }

        List<Integer> list = new ArrayList<>();

        for(int num : arr) {
            int pos = Collections.binarySearch(list, num);

            if(pos < 0) {
                pos = -pos - 1;
                if(pos == list.size()) {
                    list.add(num);
                } else {
                    list.set(pos, num);
                }
            }
        }


        out.println(list.size());
        out.flush();
        out.close();
    }
}
