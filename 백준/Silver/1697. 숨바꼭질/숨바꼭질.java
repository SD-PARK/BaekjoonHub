import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int num;
        int depth;
        public Node(int num, int depth) {
            this.num = num;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Node> q = new LinkedList<>();
        boolean[] visit = new boolean[100_001];

        q.add(new Node(n, 0));
        visit[n] = true;
        while (!q.isEmpty()) {
            Node now = q.poll();
            if (now.num == k) {
                System.out.print(now.depth);
                break;
            }
            int[] target = {now.num+1, now.num-1, now.num*2};
            for (int i=0; i<3; i++) {
                if (target[i] > 100000 || target[i] < 0) {
                    continue;
                }
                if (!visit[target[i]]) {
                    q.add(new Node(target[i], now.depth+1));
                    visit[target[i]] = true;
                }
            }
        }
    }
}