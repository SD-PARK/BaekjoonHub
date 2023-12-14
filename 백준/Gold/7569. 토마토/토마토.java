import java.io.*;
import java.util.*;

public class Main {
    static class Location {
        int x;
        int y;
        int z;
        int depth;
        public Location(int x, int y, int z, int depth) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); // 가로 길이
        int N = Integer.parseInt(st.nextToken()); // 세로 길이
        int H = Integer.parseInt(st.nextToken()); // 층수

        byte[][][] graph = new byte[H][N][M];

        // Input
        for (int d=0; d<H; d++) {
            for (int h=0; h<N; h++) {
                st = new StringTokenizer(br.readLine());
                for (int w=0; w<M; w++) {
                    graph[d][h][w] = Byte.parseByte(st.nextToken());
                }
            }
        }

        if (checkRipe(graph, N, M, H)) { // 저장될 때부터 모든 토마토가 익어있을 때
            System.out.print(0);
        } else {
            int day = bfs(graph, N, M, H);
            if (checkRipe(graph, N, M, H)) { // 시간이 흐른 뒤 토마토가 모두 익었을 때
                System.out.print(day);
            } else { // 익을 수 없는 토마토가 있을 때
                System.out.print(-1);
            }
        }
    }

    static int bfs(byte[][][] graph, int maxH, int maxW, int maxD) {
        Queue<Location> q = new LinkedList<>();
        int[] visitX = {0, 0, -1, +1, 0, 0};
        int[] visitY = {-1, +1, 0, 0, 0, 0};
        int[] visitZ = {0, 0, 0, 0, -1, 1};
        int maxDepth = 0;

        for (int d=0; d<maxD; d++) {
            for (int h=0; h<maxH; h++) {
                for (int w=0; w<maxW; w++) {
                    if (graph[d][h][w] == 1) {
                        q.offer(new Location(w, h, d, 0));
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            Location now = q.poll();

            if (now.depth > maxDepth)
                maxDepth = now.depth;

            for (int i=0; i<6; i++) {
                int nextX = now.x + visitX[i];
                int nextY = now.y + visitY[i];
                int nextZ = now.z + visitZ[i];
                if (nextX < 0 || nextX >= maxW || nextY < 0 || nextY >= maxH || nextZ < 0 || nextZ >= maxD)
                    continue;
                if (graph[nextZ][nextY][nextX] == 0) {
                    q.offer(new Location(nextX, nextY, nextZ, now.depth+1));
                    graph[nextZ][nextY][nextX] = 1;
                }
            }
        }

        return maxDepth;
    }

    static boolean checkRipe(byte[][][] graph, int maxH, int maxW, int maxD) {
        for (int d=0; d<maxD; d++) {
            for (int h=0; h<maxH; h++) {
                for (int w=0; w<maxW; w++) {
                    if (graph[d][h][w] == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}