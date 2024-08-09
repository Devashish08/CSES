// Source: https://cses.fi/problemset/task/1192
// Time Complexity: O(n*m)
// Space Complexity: O(n*m)

package GRAPH;
import java.util.*;

public class Counting_Rooms {
  private static final int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

  private static boolean isValid(int x, int y, int n, int m) {
    return x >= 0 && x < n && y >= 0 && y < m;
  }

  private static void dfs(char[][] grid, boolean[][] isVisited, int x, int y, int n, int m) {
    isVisited[ x ][ y ] = true;
    for (int[] dir : directions) {
      int newX = x + dir[ 0 ];
      int newY = y + dir[ 1 ];
      if (isValid(newX, newY, n, m) && grid[ newX ][ newY ] == '.' && !isVisited[ newX ][ newY ]) {
        dfs(grid, isVisited, newX, newY, n, m);
      }
    }
  }

  private static void iterativeDfs(char[][] grid, boolean[][] isVisited, int x, int y, int n, int m) {
    Stack<int[]> stack = new Stack<int[]>();
    stack.push(new int[]{ x, y });
    isVisited[ x ][ y ] = true;
    while (!stack.isEmpty()) {
      int[] current = stack.pop();
      int currentX = current[ 0 ];
      int currentY = current[ 1 ];
      for (int[] dir : directions) {
        int newX = currentX + dir[ 0 ];
        int newY = currentY + dir[ 1 ];
        if (isValid(newX, newY, n, m) && grid[ newX ][ newY ] == '.' && !isVisited[ newX ][ newY ]) {
          stack.push(new int[]{ newX, newY });
          isVisited[ newX ][ newY ] = true;
        }
      }

    }
  }

  public static int countRooms(char[][] grid, int n, int m) {
    int count = 0;
    boolean[][] isVisited = new boolean[ n ][ m ];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[ i ][ j ] == '.' && !isVisited[ i ][ j ]) {
          count++;
          iterativeDfs(grid, isVisited, i, j, n, m);
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(), m = sc.nextInt();
    char[][] grid = new char[ n ][ m ];
    for (int i = 0; i < n; i++) {
      grid[ i ] = sc.next().toCharArray();
    }
    Counting_Rooms obj = new Counting_Rooms();
    System.out.println(countRooms(grid, n, m));
    sc.close();
  }
}