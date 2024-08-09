package GRAPH;
import java.io.*;
import java.util.*;

public class Labyrinth {
    static final int MAX_N = 1000;
    static final int[] dx = {-1, -1, 0, 0};
    static final int[] dy = {-1, -1, 0, 0};
    static final char[] dir = {'U', 'D', 'L', 'R'};

    static int n, m;
    static char[][] grid = new char[MAX_N][MAX_N];
    static boolean[][] visited = new boolean[MAX_N][MAX_N];
    static int[][] parent = new int[MAX_N][MAX_N];
    static int sx, sy, ex, ey;

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m && grid[x][y] != '#' && !visited[x][y];
    }

    static class Pair{
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static boolean bfs(){
        Queue<Pair> q = new LinkedList<Pair>();
        q.offer(new Pair(sx, sy));
        visited[sx][sy] = true;

        while(!q.isEmpty()) {
            Pair curr = q.poll();
            int x = curr.x, y = curr.y;

            if(x == ex && y == ey) return true;

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(isValid(nx, ny)) {
                    visited[nx][ny] = true;
                    parent[nx][ny] = i;
                    q.offer(new Pair(nx, ny));
                }
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j < m; j++) {
                grid[i][j] = line.charAt(j);
                if(grid[i][j] == 'A') {
                    sx = i; sy = j;
                } else if(grid[i][j] == 'B') {
                    ex = i; ey = j;
                }
            }
        }

        if(!bfs()) {
            out.println("NO");
            out.flush();
            return;
        }

        out.println("YES");

        List<Character> path = new ArrayList<>();
        int x = ex, y = ey;
        while(x != sx || y != sy) {
            int p = parent[x][y];
            path.add(dir[p]);
            x -= dx[p];
            y -= dy[p];
        }

        Collections.reverse(path);
        out.println(path.size());
        for(char c : path) {
            out.print(c);
        }
        out.println();
        out.flush();

    }

}


//import java.util.*;
//        import java.io.*;
//
//public class Labyrinth {
//    // Define directions: Up, Down, Left, Right
//    static int[] dx = {-1, 1, 0, 0};
//    static int[] dy = {0, 0, -1, 1};
//    static char[] directions = {'U', 'D', 'L', 'R'};
//
//    static int rows, cols;
//    static char[][] maze;
//    static boolean[][] visited;
//    static int startX, startY, endX, endY;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter writer = new PrintWriter(System.out);
//
//        // Read maze dimensions
//        String[] dimensions = reader.readLine().split(" ");
//        rows = Integer.parseInt(dimensions[0]);
//        cols = Integer.parseInt(dimensions[1]);
//
//        // Initialize maze and visited array
//        maze = new char[rows][cols];
//        visited = new boolean[rows][cols];
//
//        // Read maze layout
//        for (int i = 0; i < rows; i++) {
//            String row = reader.readLine();
//            for (int j = 0; j < cols; j++) {
//                maze[i][j] = row.charAt(j);
//                if (maze[i][j] == 'A') {
//                    startX = i;
//                    startY = j;
//                } else if (maze[i][j] == 'B') {
//                    endX = i;
//                    endY = j;
//                }
//            }
//        }
//
//        // Find path
//        List<Character> path = findPath();
//
//        // Output result
//        if (path == null) {
//            writer.println("NO");
//        } else {
//            writer.println("YES");
//            writer.println(path.size());
//            for (char direction : path) {
//                writer.print(direction);
//            }
//            writer.println();
//        }
//
//        writer.flush();
//    }
//
//    static List<Character> findPath() {
//        Queue<int[]> queue = new LinkedList<>();
//        int[][][] parent = new int[rows][cols][2];
//
//        queue.offer(new int[]{startX, startY});
//        visited[startX][startY] = true;
//
//        while (!queue.isEmpty()) {
//            int[] current = queue.poll();
//            int x = current[0], y = current[1];
//
//            if (x == endX && y == endY) {
//                return reconstructPath(parent);
//            }
//
//            for (int i = 0; i < 4; i++) {
//                int newX = x + dx[i];
//                int newY = y + dy[i];
//
//                if (isValid(newX, newY)) {
//                    queue.offer(new int[]{newX, newY});
//                    visited[newX][newY] = true;
//                    parent[newX][newY] = new int[]{x, y};
//                }
//            }
//        }
//
//        return null; // No path found
//    }
//
//    static boolean isValid(int x, int y) {
//        return x >= 0 && x < rows && y >= 0 && y < cols && maze[x][y] != '#' && !visited[x][y];
//    }
//
//    static List<Character> reconstructPath(int[][][] parent) {
//        List<Character> path = new ArrayList<>();
//        int x = endX, y = endY;
//
//        while (x != startX || y != startY) {
//            int parentX = parent[x][y][0];
//            int parentY = parent[x][y][1];
//
//            for (int i = 0; i < 4; i++) {
//                if (x - parentX == dx[i] && y - parentY == dy[i]) {
//                    path.add(directions[i]);
//                    break;
//                }
//            }
//
//            x = parentX;
//            y = parentY;
//        }
//
//        Collections.reverse(path);
//        return path;
//    }
//}