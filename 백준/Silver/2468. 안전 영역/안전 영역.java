import java.io.*;
import java.util.*;

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
        int[][] map = new int[n][n];
        boolean[][] visit;
        int maxHeight = 0;
        int maxSafetyArea = 0;

        // Input
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > maxHeight)
                    maxHeight = map[i][j];
            }
        }

        // BFS
        for (int depth=0; depth<maxHeight; depth++) {
            int safetyArea = 0;
            visit = new boolean[n][n];
            for (int h=0; h<n; h++) {
                for (int w=0; w<n; w++) {
                    if (!visit[h][w] && map[h][w] > depth) {
                        bfs(map, visit, n, depth, new Location(w, h));
                        safetyArea++;
                    }
                }
            }

            if (safetyArea > maxSafetyArea)
                maxSafetyArea = safetyArea;
        }

        // Output
        System.out.print(maxSafetyArea);
    }

    static void bfs(int[][] map, boolean[][] visit, int mapLen, int depth, Location loc) {
        Queue<Location> q = new LinkedList<>();
        q.add(loc);
        int[] targetX = {0, 0, -1, 1};
        int[] targetY = {-1, 1, 0, 0};
        while (!q.isEmpty()) {
            Location now = q.poll();
            for (int i=0; i<4; i++) {
                int x = now.x + targetX[i];
                int y = now.y + targetY[i];
                if (x < 0 || x >= mapLen || y < 0 || y >= mapLen)
                    continue;
                if (!visit[y][x] && map[y][x] > depth) {
                    q.add(new Location(x, y));
                    visit[y][x] = true;
                }
            }
        }
    }
}