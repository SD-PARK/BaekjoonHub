import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static class Score {
        public String 이름;
        public int 국어;
        public int 영어;
        public int 수학;

        public Score(String 이름, int 국어, int 영어, int 수학) {
            this.이름 = 이름;
            this.국어 = 국어;
            this.영어 = 영어;
            this.수학 = 수학;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Score[] scores = new Score[n];

        // 입력
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String 이름 = st.nextToken();
            int 국어 = Integer.parseInt(st.nextToken());
            int 영어 = Integer.parseInt(st.nextToken());
            int 수학 = Integer.parseInt(st.nextToken());
            scores[i] = new Score(이름, 국어, 영어, 수학);
        }

        // 정렬
        Arrays.sort(scores, Comparator
                .comparingInt((Score s) -> s.국어).reversed()
                .thenComparingInt(s -> s.영어)
                .thenComparingInt(s -> -s.수학)
                .thenComparing(s -> s.이름));

        // 출력
        for (Score score: scores) {
            sb.append(score.이름 + "\n");
        }
        System.out.print(sb);
    }
}