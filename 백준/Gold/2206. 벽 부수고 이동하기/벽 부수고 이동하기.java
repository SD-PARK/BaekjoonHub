import java.io.*;
import java.util.*;

public class Main {
    static class Location {
        int x;
        int y;
        int depth;
        boolean crush;
        public Location(int x, int y, int depth, boolean crush) {
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.crush = crush;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 세로 길이
        int M = Integer.parseInt(st.nextToken()); // 가로 길이

        boolean[][] map = new boolean[N][M];
        boolean[][][] visit = new boolean[2][N][M];

        // Input
        for (int h=0; h<N; h++) {
            String str = br.readLine();
            for (int w=0; w<M; w++) {
                map[h][w] = (str.charAt(w) == '1');
            }
        }

        int result = bfs(map, visit, N, M);
        System.out.print(result);
    }

    static int bfs(boolean[][] map, boolean[][][] visit, int maxH, int maxW) {
        Queue<Location> q = new LinkedList<>();
        int[] visitX = {0, 0, -1, +1};
        int[] visitY = {-1, +1, 0, 0};

        q.offer(new Location(0, 0, 1, false));
        visit[0][0][0] = true;

        while (!q.isEmpty()) {
            Location now = q.poll();

            if (now.x+1 == maxW && now.y+1 == maxH)
                return now.depth;

            for (int i=0; i<4; i++) {
                int nextX = now.x + visitX[i];
                int nextY = now.y + visitY[i];

                if (nextX < 0 || nextX >= maxW || nextY < 0 || nextY >= maxH)
                    continue;

                if (map[nextY][nextX]) { // 벽 있음
                    if (!now.crush && !visit[1][nextY][nextX]) {
                        q.offer(new Location(nextX, nextY, now.depth+1, true));
                        visit[1][nextY][nextX] = true;
                    }
                } else { // 벽 없음
                    if (!visit[now.crush ? 1 : 0][nextY][nextX]) {
                        q.offer(new Location(nextX, nextY, now.depth+1, now.crush));
                        visit[now.crush ? 1 : 0][nextY][nextX] = true;
                    }
                }
            }
        }
        return -1;
    }
}