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
        StringBuilder sb = new StringBuilder();
        Queue<Node> q = new LinkedList<>();
        int[] visit = new int[100_001];
        Arrays.fill(visit, -1);
        Stack<Integer> route = new Stack<>();

        // Input
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // BFS
        q.add(new Node(n, 0));
        visit[n] = -2;
        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.num == k) {
                route.push(now.num);
                while (visit[route.peek()] >= 0) {
                    route.push(visit[route.peek()]);
                }
                break;
            }

            int[] target = {now.num+1, now.num-1, now.num*2};
            for (int i=0; i<3; i++) {
                if (target[i] > 100000 || target[i] < 0) {
                    continue;
                }
                if (visit[target[i]] == -1) {
                    q.add(new Node(target[i], now.depth+1));
                    visit[target[i]] = now.num;
                }
            }
        }

        // Output
        System.out.println(route.size() - 1);
        while (!route.isEmpty()) {
            sb.append(route.pop() + " ");
        }
        System.out.print(sb);
    }
}