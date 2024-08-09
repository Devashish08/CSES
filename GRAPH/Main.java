//package DP;
//import java.util.*;
//import java.io.*;
//
//public class Main {
//    static int n, m;
//    static boolean[] vis;
//    static List<List<Integer>> graph;
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter writer = new PrintWriter(System.out);
//
//        String[] line = reader.readLine().split(" ");
//        n = Integer.parseInt(line[0]);
//        m = Integer.parseInt(line[1]);
//
//        graph = new ArrayList<>();
//        for(int i = 0; i <= n; i++) {
//            graph.add(new ArrayList<>());
//        }
//
//        for(int j = 0; j < m; j++) {
//            line = reader.readLine().split(" ");
//            int a = Integer.parseInt(line[0]);
//            int b = Integer.parseInt(line[1]);
//            graph.get(a).add(b);
//            graph.get(b).add(a);
//        }
//
//        vis = new boolean[n + 1];
//        int[] parent = new int[n + 1];
//        Queue<Integer> q = new LinkedList<>();
//        q.offer(1);
//        vis[1] = true;
//
//        while(!q.isEmpty()) {
//            int current = q.remove();
//
//            if(current == n) {
//                break;
//            }
//
//            for(int neighbour : graph.get(current)) {
//                if(!vis[neighbour]) {
//                    vis[neighbour] = true;
//                    parent[neighbour] = current;
//                    q.offer(neighbour);
//                }
//            }
//        }
//
//        if(!vis[n]) {
//            writer.println("IMPOSSIBLE");
//        } else {
//            List<Integer> path = new ArrayList<>();
//            for(int i = n; i != 0; i = parent[i]) {
//                path.add(i);
//            }
//            Collections.reverse(path);
//            writer.println(path.size());
//            for(int node : path) {
//                writer.print(node + " ");
//            }
//        }
//        writer.flush();
//    }
//}