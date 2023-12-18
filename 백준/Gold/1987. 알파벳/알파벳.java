import java.io.*;
import java.util.*;

public class Main {
    static int[] targetX = {0, 0, -1, 1};
    static int[] targetY = {-1, 1, 0, 0};
    static int maxH, maxW;
    static boolean[] visit = new boolean[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        maxH = Integer.parseInt(st.nextToken()); // 세로 길이
        maxW = Integer.parseInt(st.nextToken()); // 가로 길이
        int[][] map = new int[maxH][maxW];

        // Input
        for (int y=0; y<maxH; y++) {
            String str = br.readLine();
            for (int x=0; x<maxW; x++) {
                map[y][x] = str.charAt(x);
            }
        }

        visit[map[0][0] - 65] = true;
        System.out.print(dfs(map, 0, 0));
    }

    static int dfs(int[][] map, int x, int y) {
        int depth = 0;
        visit[map[y][x]-65] = true;

        for (int i=0; i<4; i++) {
            int nextX = x + targetX[i];
            int nextY = y + targetY[i];

            if (nextX < 0 || nextX >= maxW || nextY < 0 || nextY >= maxH)
                continue;

            int nextVisit = map[nextY][nextX] - 65;
            if (!visit[nextVisit])
                depth = Math.max(depth, dfs(map, nextX, nextY));
        }

        visit[map[y][x]-65] = false;
        return depth+1;
    }
}