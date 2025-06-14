import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static final int START_CITY = 0;

    static int cityCount;
    static int[][] travelCosts;
    static boolean[] visited;
    static int minTourCost;

    public static void main(String[] args) throws IOException {
        readInput();

        visited[START_CITY] = true;
        backtrack(1, START_CITY, 0);

        System.out.print(minTourCost);
    }

    private static void readInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        cityCount = Integer.parseInt(reader.readLine());
        travelCosts = new int[cityCount][cityCount];
        for (int i=0; i<cityCount; i++) {
            travelCosts[i] = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
        visited = new boolean[cityCount];
        minTourCost = Integer.MAX_VALUE;
    }

    private static void backtrack(int depth, int currentCity, int cost) {
        for(int nextCity=0; nextCity<cityCount; nextCity++) {
            int moveCost = travelCosts[currentCity][nextCity];
            if (visited[nextCity] || moveCost == 0) continue;

            int nextCost = cost + moveCost;
            if (nextCost >= minTourCost) continue;

            visited[nextCity] = true;

            if (depth == cityCount-1) {
                updateMinCostIfPossible(nextCity, nextCost);
            } else {
                backtrack(depth + 1, nextCity, nextCost);
            }

            visited[nextCity] = false;
        }
    }

    private static void updateMinCostIfPossible(int lastCity, int costSoFar) {
        int returnCost = travelCosts[lastCity][START_CITY];
        if (returnCost != 0) {
            minTourCost = Math.min(minTourCost, costSoFar + returnCost);
        }
    }
}