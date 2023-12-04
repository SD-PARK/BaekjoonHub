import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 정점의 개수
        int m = Integer.parseInt(st.nextToken()); // 간선의 개수
        boolean[][] edge = new boolean[n+1][n+1]; // 인접 행렬
        boolean[] complete = new boolean[n+1]; // 탐색한 노드
        int cnt = 0; // 방향 없는 그래프 개수

        // 간선 입력
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken()), v2 = Integer.parseInt(st.nextToken());
            edge[v1][v2] = true;
            edge[v2][v1] = true;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i=1; i<=n; i++) {
            if (!complete[i]) {
                cnt++;

                // BFS
                q.add(i);
                complete[i] = true;
                while (!q.isEmpty()) {
                    int now = q.poll();
                    for (int j=1; j<=n; j++) {
                        if (edge[now][j] && !complete[j]) {
                            complete[j] = true;
                            q.add(j);
                        }
                    }
                }
            }
        }

        // 출력
        System.out.print(cnt);
    }
}