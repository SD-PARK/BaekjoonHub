import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        boolean[][] map = new boolean[k][k];
        PriorityQueue<Integer> result = new PriorityQueue<>();

        for (int i=0; i<k; i++) {
            String line = br.readLine();
            for (int j=0; j<k; j++) {
                boolean temp = (line.charAt(j) == '1');
                map[i][j] = temp;
            }
        }

        for (int y=0; y<k; y++) {
            for (int x=0; x<k; x++) {
                if (map[y][x]) {
                    result.add(dfs(x, y, map));
                }
            }
        }

        int resultLen = result.size();
        System.out.println(resultLen);
        while (resultLen-- > 0) {
            System.out.println(result.poll());
        }
    }

    static int dfs(int x, int y, boolean[][] map) {
        int mapLen = map.length;
        int cnt = 1;
        map[y][x] = false;

        // 상
        if (y > 0 && map[y-1][x]) {
            cnt += dfs(x, y-1, map);
        }
        // 하
        if (y+1 < mapLen && map[y+1][x]) {
            cnt += dfs(x, y+1, map);
        }
        // 좌
        if (x > 0 && map[y][x-1]) {
            cnt += dfs(x-1, y, map);
        }
        // 우
        if (x+1 < mapLen && map[y][x+1]) {
            cnt += dfs(x+1, y, map);
        }

        return cnt;
    }
}