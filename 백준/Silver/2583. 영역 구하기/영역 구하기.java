import java.io.*;
import java.util.*;

public class Main {
    static int[] targetX = {0, 0, -1, 1};
    static int[] targetY = {-1, 1, 0, 0};
    static int maxH, maxW;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        maxH = Integer.parseInt(st.nextToken()); // 세로 길이
        maxW = Integer.parseInt(st.nextToken()); // 가로 길이
        int squareCnt = Integer.parseInt(st.nextToken());
        boolean[][] paper = new boolean[maxH][maxW];
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i=0; i<squareCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int lu_x = Integer.parseInt(st.nextToken());
            int lu_y = Integer.parseInt(st.nextToken());
            int rd_x = Integer.parseInt(st.nextToken());
            int rd_y = Integer.parseInt(st.nextToken());

            for (int y=lu_y; y<rd_y; y++) {
                for (int x=lu_x; x<rd_x; x++) {
                    paper[y][x] = true;
                }
            }
        }

        for (int h=0; h<maxH; h++) {
            for (int w=0; w<maxW; w++) {
                if (!paper[h][w]) {
                    q.offer(dfs(paper, w, h));
                }
            }
        }

        System.out.println(q.size());
        while (!q.isEmpty()) {
            System.out.print(q.poll() + " ");
        }
    }

    static int dfs(boolean[][] paper, int x, int y) {
        int size = 1;
        paper[y][x] = true;

        for (int i=0; i<4; i++) {
            int nextX = x + targetX[i];
            int nextY = y + targetY[i];

            if (nextX < 0 || nextX >= maxW || nextY < 0 || nextY >= maxH)
                continue;

            if (!paper[nextY][nextX])
                size += dfs(paper, nextX, nextY);
        }

        return size;
    }
}