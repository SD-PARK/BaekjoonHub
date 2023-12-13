import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Location {
        int x;
        int y;
        int depth;

        public Location(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int l = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken()), startY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken()), endY = Integer.parseInt(st.nextToken());

            System.out.println(bfs(l, new Location(startX, startY, 0), new Location(endX, endY, 0)));
        }
    }

    static int bfs(int gridLen, Location start, Location end) {
        int[] targetX = {1, 2, 2, 1, -1, -2, -2, -1};
        int[] targetY = {-2, -1, 1, 2, 2, 1, -1, -2};
        boolean[][] visit = new boolean[gridLen][gridLen];
        Queue<Location> q = new LinkedList<>();

        q.add(start);
        visit[start.y][start.x] = true;
        while (!q.isEmpty()) {
            Location now = q.poll();

            if (now.x == end.x && now.y == end.y) {
                return now.depth;
            }

            for (int i = 0; i < 8; i++) {
                int x = now.x + targetX[i];
                int y = now.y + targetY[i];

                if (x < 0 || x >= gridLen || y < 0 || y >= gridLen)
                    continue;

                if (!visit[y][x]) {
                    q.add(new Location(x, y, now.depth + 1));
                    visit[y][x] = true;
                }
            }
        }

        return -1;
    }
}