import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static class Location {
        int x;
        int y;
        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] grid = new int[n][n];

        // Input
        for (int i=0; i<n; i++) {
            String str = br.readLine();
            for (int j=0; j<n; j++) {
                char ch = str.charAt(j);
                switch (ch) {
                    case 'R':
                        grid[i][j] = 0;
                        break;
                    case 'B':
                        grid[i][j] = 1;
                        break;
                    case 'G':
                        grid[i][j] = 2;
                        break;
                }
            }
        }

        // Output
        System.out.print(bfs(grid, n, false) + " ");
        System.out.print(bfs(grid, n, true));
    }

    static int bfs(int[][] grid, int gridLen, boolean colorBlindness) {
        boolean[][] visit = new boolean[gridLen][gridLen];
        int areaCnt = 0;
        Queue<Location> q = new LinkedList<>();
        int[] targetX = {0, 0, -1, 1};
        int[] targetY = {-1, 1, 0, 0};

        for (int h=0; h<gridLen; h++) {
            for (int w=0; w<gridLen; w++) {
                if (!visit[h][w]) {
                    q.add(new Location(w, h));
                    visit[h][w] = true;

                    while (!q.isEmpty()) {
                        Location now = q.poll();
                        for (int i=0; i<4; i++) {
                            int x = now.x + targetX[i];
                            int y = now.y + targetY[i];
                            if (x < 0 || y < 0 || x >= gridLen || y >= gridLen)
                                continue;
                            if (colorBlindness) {
                                if (!visit[y][x] && grid[y][x]%2 == grid[now.y][now.x]%2) {
                                    q.add(new Location(x, y));
                                    visit[y][x] = true;
                                }
                            } else {
                                if (!visit[y][x] && grid[y][x] == grid[now.y][now.x]) {
                                    q.add(new Location(x, y));
                                    visit[y][x] = true;
                                }
                            }
                        }
                    }
                    areaCnt++;
                }
            }
        }
        return areaCnt;
    }
}