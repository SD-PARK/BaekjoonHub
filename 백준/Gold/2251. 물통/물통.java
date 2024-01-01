import java.io.*;
import java.util.*;

public class Main {
    static TreeSet<Integer> set = new TreeSet<>();
    static boolean[][] visit = new boolean[201][201];
    static int[] limit = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<3; i++) {
            limit[i] = Integer.parseInt(st.nextToken());
        }

        // DFS
        dfs(new int[]{0, 0, limit[2]});

        // Output
        for (int i: set)
            sb.append(i + " ");
        System.out.print(sb);
    }

    static void dfs(int[] water) {
        visit[water[0]][water[1]] = true;

        if (water[0] == 0)
            set.add(water[2]);

        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                if (i == j)
                    continue;

                int[] nextWater = Arrays.copyOf(water, 3);

                if (water[i] + water[j] > limit[j]) {
                    nextWater[i] = water[i] - (limit[j] - water[j]);
                    nextWater[j] = limit[j];
                } else {
                    nextWater[i] = 0;
                    nextWater[j] = water[i] + water[j];
                }

                if (!visit[nextWater[0]][nextWater[1]])
                    dfs(nextWater);
            }
        }
    }
}