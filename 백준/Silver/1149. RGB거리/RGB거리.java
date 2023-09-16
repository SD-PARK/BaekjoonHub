import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] val = new int[n][3];
        int[][] d = new int[n][3];
        int result = 1_000_000;

        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            val[i][0] = Integer.parseInt(st.nextToken());
            val[i][1] = Integer.parseInt(st.nextToken());
            val[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int color=0; color<3; color++) {
            for (int i=0; i<3; i++) {
                d[0][i] = 1_000_000;
                if (i == color)
                    d[0][i] = val[0][i];
            }
            for (int i=1; i<n; i++) {
                d[i][0] = Math.min(d[i-1][1], d[i-1][2]) + val[i][0];
                d[i][1] = Math.min(d[i-1][0], d[i-1][2]) + val[i][1];
                d[i][2] = Math.min(d[i-1][0], d[i-1][1]) + val[i][2];
            }
            for (int i=0; i<3; i++) {
                result = Math.min(result, d[n-1][i]);
            }
        }
        
        System.out.print(result);
    }
}