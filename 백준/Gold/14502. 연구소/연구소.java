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
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 세로 길이
        int m = Integer.parseInt(st.nextToken()); // 가로 길이
        int[][] map = new int[n][m];
        int maxSafeAreaCnt = 0;

        // Input
        for (int y=0; y<n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x=0; x<m; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        // Build the Wall
        for (int w1=n*m-1; w1>=2; w1--) {
            int w1_x = w1%m, w1_y = w1/m;

            if (map[w1_y][w1_x] != 0)
                continue;
            else
                map[w1_y][w1_x] = 1;

            for (int w2=w1-1; w2>=1; w2--) {
                int w2_x = w2%m, w2_y = w2/m;

                if (map[w2_y][w2_x] != 0)
                    continue;
                else
                    map[w2_y][w2_x] = 1;

                for (int w3=w2-1; w3>=0; w3--) {
                    int w3_x = w3%m, w3_y = w3/m;

                    if (map[w3_y][w3_x] != 0)
                        continue;
                    else
                        map[w3_y][w3_x] = 1;

                    maxSafeAreaCnt = Math.max(maxSafeAreaCnt, getSafetyArea(map, n, m));

                    map[w3_y][w3_x] = 0;
                }

                map[w2_y][w2_x] = 0;
            }

            map[w1_y][w1_x] = 0;
        }

        System.out.print(maxSafeAreaCnt);
    }

    static int getSafetyArea(int[][] map, int maxH, int maxW) {
        Queue<Location> q = new LinkedList<>();
        boolean[][] visit = new boolean[maxH][maxW];
        int SafetyAreaCnt = 0;

        // Virus Setting
        for (int h=0; h<maxH; h++) {
            for (int w=0; w<maxW; w++) {
                if (map[h][w] == 2 && !visit[h][w]) {
                    bfs(map, visit, maxH, maxW, new Location(w, h));
                }
            }
        }

        // Safety Area Count
        for (int h=0; h<maxH; h++) {
            for (int w=0; w<maxW; w++) {
                if (map[h][w] == 0 && !visit[h][w]) {
                    SafetyAreaCnt++;
                }
            }
        }

        return SafetyAreaCnt;
    }

    static void bfs(int[][] map, boolean[][] visit, int maxH, int maxW, Location start) {
        Queue<Location> q = new LinkedList<>();
        int[] visitX = {0, 0, -1, 1};
        int[] visitY = {-1, 1, 0, 0};

        q.add(start);
        visit[start.y][start.x] = true;

        while(!q.isEmpty()) {
            Location now = q.poll();
            for (int i=0; i<4; i++) {
                int x = now.x + visitX[i];
                int y = now.y + visitY[i];

                if (x < 0 || x >= maxW || y < 0 || y >= maxH)
                    continue;

                if (map[y][x] == 0 && !visit[y][x]) {
                    q.add(new Location(x, y));
                    visit[y][x] = true;
                }
            }
        }
    }
}