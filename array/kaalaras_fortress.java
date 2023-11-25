package array;

import java.util.*;;

public class kaalaras_fortress {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(solve(m, n, arr));
    }

    private static int solve(int m, int n, int[][] grid) {
        int maxTime = 0;

        int[][] temp = copyMatrix(grid);
        int ans = calculateTime(temp, m, n);

        if (ans == -1) {
            return 0;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    temp[i][j] = 1;
                    int time = calculateTime(temp, m, n);

                    if (time != -1) {
                        maxTime = Math.max(maxTime, time);
                    }

                    temp[i][j] = 0;
                }
            }
        }
        return Math.max(ans, maxTime) + 1;
    }

    private static int calculateTime(int[][] grid, int m, int n) {
        int dRow[] = {-1, 0, 1, 0};
        int dCol[] = {0, 1, 0, -1};
        int[][] vis = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0}); 

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int time = current[2];

            if (row == m - 1 && col == n - 1) {
                return time;
            }

            vis[row][col] = 1;

            for (int i = 0; i < 4; i++) {
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];
                if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && grid[nRow][nCol] == 0 && vis[nRow][nCol] == 0) {
                    queue.offer(new int[]{nRow, nCol, time + 1});
                    vis[nRow][nCol] = 1;
                }
            }
        }

        return -1;
    }

    private static int[][] copyMatrix(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        int[][] copy = new int[M][N];

        for (int i = 0; i < M; i++) {
            System.arraycopy(grid[i], 0, copy[i], 0, N);
        }
        return copy;
    }
}
    
