import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] edge;
    static boolean[] complete;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
        edge = new boolean[n+1][n+1];

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken()), v2 = Integer.parseInt(st.nextToken());
            edge[v1][v2] = true;
            edge[v2][v1] = true;
        }

        // DFS
        complete = new boolean[n+1];
        dfs(v, n);
        System.out.println();

        // BFS
        complete = new boolean[n+1];
        bfs(v, n);
    }

    static void dfs(int v, int maxLen) {
        complete[v] = true;
        System.out.print(v + " ");

        for (int i=1; i<=maxLen; i++) {
            if (edge[v][i] && !complete[i]) {
                dfs(i, maxLen);
            }
        }
    }

    static void bfs(int v, int maxLen) {
        Queue<Integer> q = new LinkedList<>();

        complete[v] = true;
        q.add(v);

        while (!q.isEmpty()) {
            int now = q.poll();
            System.out.print(now + " ");
            for (int i=1; i<=maxLen; i++) {
                if (edge[now][i] && !complete[i]) {
                    complete[i] = true;
                    q.add(i);
                }
            }
        }
    }
}