//import java.util.*;
//import java.io.*;
//
//public class Main {
//    static class DisjointSet {
//        int[] parent;
//        int[] rank;
//
//        public DisjointSet(int n) {
//            parent = new int[n];
//            rank = new int[n];
//            for (int i = 0; i < n; i++) {
//                parent[i] = i;
//            }
//        }
//
//        public int find(int x) {
//            if (parent[x] != x) {
//                parent[x] = find(parent[x]);
//            }
//            return parent[x];
//        }
//
//        public boolean union(int x, int y) {
//            int px = find(x);
//            int py = find(y);
//            if (px == py) {
//                return false;
//            }
//            if (rank[px] < rank[py]) {
//                parent[px] = py;
//            } else if (rank[px] > rank[py]) {
//                parent[py] = px;
//            } else {
//                parent[py] = px;
//                rank[px]++;
//            }
//            return true;
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter out = new PrintWriter(System.out);
//
//        String[] line = br.readLine().split(" ");
//        int n = Integer.parseInt(line[0]);
//        int m = Integer.parseInt(line[1]);
//
//        DisjointSet ds = new DisjointSet(n);
//
//        // Process existing roads
//        for (int i = 0; i < m; i++) {
//            line = br.readLine().split(" ");
//            int a = Integer.parseInt(line[0]) - 1;
//            int b = Integer.parseInt(line[1]) - 1;
//            ds.union(a, b);
//        }
//
//        // Count disjoint sets
//        Set<Integer> components = new HashSet<>();
//        for (int i = 0; i < n; i++) {
//            components.add(ds.find(i));
//        }
//
//        // Number of new roads needed
//        int newRoadsCount = components.size() - 1;
//
//        // Determine new roads
//        List<int[]> newRoads = new ArrayList<>();
//        List<Integer> componentList = new ArrayList<>(components);
//        for (int i = 1; i < componentList.size(); i++) {
//            newRoads.add(new int[]{componentList.get(0) + 1, componentList.get(i) + 1});
//        }
//
//        // Print output
//        out.println(newRoadsCount);
//        for (int[] road : newRoads) {
//            out.println((road[0]) + " " + (road[1]));
//        }
//
//        out.flush();
//    }
//}


package GRAPH;


import java.util.*;
import java.io.*;

public class Building_Roads {
    static int n, m;
    static boolean[][] visited;
    static ArrayList<ArrayList<Integer>> graph;
    static class DisjointSet {
        int[] parent;
        int[] rank;

        public DisjointSet(int n) {
            parent = new int[ n ];
            rank = new int[ n ];
            for(int i = 0; i < n; i++) {
                parent[ i ] = i;
            }
        }

        public int find(int x) {
            if(parent[ x ] != x) {
                parent[ x ] = find(parent[ x ]);
            }
            return parent[ x ];
        }

        public boolean union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if(px == py) {
                return false;
            }
            if(rank[ px ] < rank[ py ]) {
                parent[ px ] = py;
            } else if(rank[ px ] > rank[ py ]) {
                parent[ py ] = px;
            } else {
                parent[ py ] = px;
                rank[ px ]++;
            }
            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[ 0 ]);
        m = Integer.parseInt(line[ 1 ]);

        visited = new boolean[ n ][ m ];
        graph = new ArrayList<>(n + 1);
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i <= m; i++) {
            line = br.readLine().split(" ");
            int a = Integer.parseInt(line[ 0 ]);
            int b = Integer.parseInt(line[ 1 ]);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        ArrayList<Integer> components = new ArrayList<>();

        for(int i = 1; i <= n; i++) {
            if(!visited[ i ][ 0 ]) {
                components.add(i);
                dfs(i);
            }
        }

        int newRoadsCount = components.size() - 1;

        out.println(newRoadsCount);
        for(int i = 1; i < components.size(); i++) {
            out.println(components.get(0) + " " + components.get(i));
        }

        out.flush();
    }

    static void dfs(int v) {
        visited[v][0] = true;
        for(int neighbor : graph.get(v)) {
            if(!visited[neighbor][0]) {
                dfs(neighbor);
            }
        }
    }
}

