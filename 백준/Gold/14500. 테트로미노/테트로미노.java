import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][][] block = {
            // ----
        {{0,1},{0,2},{0,3}},
        {{1,0},{2,0},{3,0}},
            // --
            // --
        {{0,1},{1,0},{1,1}},
            // -
            // ---
        {{1,0},{2,0},{2,1}},
        {{1,0},{2,0},{2,-1}},
        {{0,1},{0,2},{-1,2}},
        {{1,0},{1,1},{1,2}},
        {{0,1},{1,1},{2,1}},
        {{0,1},{1,0},{2,0}},
        {{1,0},{0,1},{0,2}},
        {{0,1},{0,2},{1,2}},
            //  --
            // --
        {{0,1},{-1,1},{-1,2}},
        {{0,1},{1,1},{1,2}},
        {{1,0},{1,1},{2,1}},
        {{1,0},{1,-1},{2,-1}},
            // ---
            //  -
        {{0,1},{1,1},{0,2}},
        {{1,0},{1,1},{2,0}},
        {{1,0},{1,-1},{2,0}},
        {{0,1},{-1,1},{0,2}},
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[][] paper = new int[N][M];
        int result = 0;

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                for (int k=0; k<19; k++) {
                    int tempSum = 0;
                    tempSum += paper[i][j];
                    for (int l=0; l<3; l++) {
                        int y = block[k][l][0] + i;
                        int x = block[k][l][1] + j;

                        if (y>=0 && y<N && x>=0 && x<M) {
                            tempSum += paper[y][x];
                        } else {
                            tempSum = -1;
                            break;
                        }
                    }
                    result = Math.max(result, tempSum);
                }
            }
        }

        System.out.print(result);
    }
}