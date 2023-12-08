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
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken()); // 가로 길이
            int n = Integer.parseInt(st.nextToken()); // 세로 길이
            int k = Integer.parseInt(st.nextToken()); // 배추 개수

            boolean[][] graph = new boolean[n][m];
            int wormCnt = 0;

            // Input
            while (k-- > 0) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph[y][x] = true;
            }

            // BFS
            for (int h=0; h<n; h++) {
                for (int w=0; w<m; w++) {
                    if (graph[h][w]) {
                        wormCnt++;
                        bfs(new Location(w, h), graph, n, m);
                    }
                }
            }

            // Output
            System.out.println(wormCnt);
        }
    }

    static void bfs(Location start, boolean[][] graph, int maxH, int maxW) {
        Queue<Location> q = new LinkedList<>();

        q.offer(start);
        graph[start.y][start.x] = false;

        while (!q.isEmpty()) {
            Location now = q.poll();
            // 상
            if (now.y > 0 && graph[now.y-1][now.x]) {
                q.offer(new Location(now.x, now.y-1));
                graph[now.y-1][now.x] = false;
            }
            // 하
            if (now.y+1 < maxH && graph[now.y+1][now.x]) {
                q.offer(new Location(now.x, now.y+1));
                graph[now.y+1][now.x] = false;
            }
            // 좌
            if (now.x > 0 && graph[now.y][now.x-1]) {
                q.offer(new Location(now.x-1, now.y));
                graph[now.y][now.x-1] = false;
            }
            // 우
            if (now.x+1 < maxW && graph[now.y][now.x+1]) {
                q.offer(new Location(now.x+1, now.y));
                graph[now.y][now.x+1] = false;
            }
        }
    }
}