import java.io.*;
import java.util.*;

public class Main {
    static class Location {
        int y;
        int x;
        int depth;
        public Location(int y, int x, int depth) {
            this.y = y;
            this.x = x;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[n][m];

        // 미로 입력
        for (int y=0; y<n; y++) {
            String mapY = br.readLine();
            for (int x=0; x<m; x++) {
                boolean temp = (mapY.charAt(x) == '1');
                map[y][x] = temp;
            }
        }

        // BFS
        Queue<Location> q = new LinkedList<>();
        map[0][0] = false;
        q.add(new Location(0, 0, 1));
        while (!q.isEmpty()) {
            Location now = q.poll();
            if (now.x == m-1 && now.y == n-1) {
                System.out.print(now.depth);
                break;
            }
            // 상
            if (now.y > 0 && map[now.y-1][now.x]) {
                map[now.y-1][now.x] = false;
                q.add(new Location(now.y-1, now.x, now.depth+1));
            }
            // 하
            if (now.y+1 < n && map[now.y+1][now.x]) {
                map[now.y+1][now.x] = false;
                q.add(new Location(now.y+1, now.x, now.depth+1));
            }
            // 좌
            if (now.x > 0 && map[now.y][now.x-1]) {
                map[now.y][now.x-1] = false;
                q.add(new Location(now.y, now.x-1, now.depth+1));
            }
            // 우
            if (now.x+1 < m && map[now.y][now.x+1]) {
                map[now.y][now.x+1] = false;
                q.add(new Location(now.y, now.x+1, now.depth+1));
            }
        }
    }
}