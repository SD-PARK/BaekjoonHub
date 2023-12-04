import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i=0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
            int[][] cases = new int[N+1][M+1];

            for (int n=1; n<=N; n++) {
                for (int m=n; m<=M; m++) {
                    if (n == 1) {
                        cases[n][m] = m;
                    } else {
                        for (int j=1; j<=(m-n)+1; j++) {
                            cases[n][m] += cases[n-1][m-j];
                        }
                    }
                }
            }
            bw.write(cases[N][M] + "\n");
        }
        bw.close();
    }
}