import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i=0; i<T; i++) {
            int M = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> minPQ = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> maxPQ = new PriorityQueue<>();

            // 수열 입력
            StringTokenizer st = null;
            bw.write((M/2)+1 + "");
            for (int j=0; j<M; j++) {
                // 1줄 당 10개의 수 입력
                if (j%10 == 0) {
                    st = new StringTokenizer(br.readLine());
                }

                // 배열에 수 입력 및 정렬
                int input = Integer.parseInt(st.nextToken());

                if (minPQ.size() == maxPQ.size()) {
                    minPQ.add(input);
                } else {
                    maxPQ.add(input);
                }

                if (!minPQ.isEmpty() && !maxPQ.isEmpty()) {
                    if (minPQ.peek() > maxPQ.peek()) {
                        minPQ.add(maxPQ.poll());
                        maxPQ.add(minPQ.poll());
                    }
                }

                // 중앙값 저장
                if (j%2 == 0) {
                    if (j%20 == 0) {
                        bw.write("\n");
                    }
                    bw.write(minPQ.peek() + " ");
                }
            }
            bw.write("\n");
        }
        bw.close();
    }
}