import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] d = new int[n][2];
        int max = 0;
        for (int i=0; i<n; i++) {
            int wine = Integer.parseInt(br.readLine());
            
            d[i][0] = wine;
            d[i][1] = 0;

            if (i > 0)
                d[i][1] = d[i-1][0] + wine;

            if (i > 2) {
                d[i][0] = Math.max(d[i-2][0], Math.max(d[i-2][1], d[i-3][1])) + wine;
            } else if (i > 1) {
                d[i][0] = Math.max(d[i-2][0], d[i-2][1]) + wine;
            }

            max = Math.max(max, Math.max(d[i][0], d[i][1]));
        }
        System.out.print(max);
    }
}