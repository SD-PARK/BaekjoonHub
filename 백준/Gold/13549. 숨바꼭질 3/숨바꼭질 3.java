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
        int time = Integer.MAX_VALUE;

        q.add(new Node(n, 0));
        while (!q.isEmpty()) {
            Node now = q.poll();
            visit[now.num] = true;
            int[] target = {now.num*2, now.num+1, now.num-1};

            if (now.num == k) {
                time = Math.min(time, now.depth);
            }

            for (int i=0; i<3; i++) {
                if (target[i] > 100000 || target[i] < 0) {
                    continue;
                }
                if (!visit[target[i]]) {
                    if (i == 0) {
                        q.add(new Node(target[i], now.depth));
                    } else {
                        q.add(new Node(target[i], now.depth+1));
                    }
                }
            }
        }

        System.out.print(time);
    }
}