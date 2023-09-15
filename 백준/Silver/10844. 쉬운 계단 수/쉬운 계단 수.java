import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] d = new int[n][10];
        int mod = 1_000_000_000;

        Arrays.fill(d[0], 1);
        d[0][0] = 0;
        for (int i=1; i<n; i++) {
            d[i][0] = d[i-1][1] % mod;
            for (int j=1; j<9; j++)
                d[i][j] = (d[i-1][j-1] + d[i-1][j+1]) % mod;
            d[i][9] = d[i-1][8] % mod;
        }

        int sum = 0;
        for (int i: d[n-1])
            sum = (sum + i) % mod;
        System.out.print(sum);
    }
}