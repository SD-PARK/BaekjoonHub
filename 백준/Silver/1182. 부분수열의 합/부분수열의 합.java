import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static int target;
    private static int numberCount;
    private static int[] numbers;
    private static int matchingCount;

    public static void main(String[] args) throws IOException {
        readInput();
        dfs(0, 0);
        if (target == 0) matchingCount--;
        System.out.print(matchingCount);
    }

    private static void readInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] settings = reader.readLine().split("\\s+");

        target = Integer.parseInt(settings[1]);
        numberCount = Integer.parseInt(settings[0]);
        numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        matchingCount = 0;
    }

    private static void dfs(int index, int sum) {
        if (index == numberCount) {
            if (sum == target) matchingCount++;
            return;
        }
        dfs(index + 1, sum);
        dfs(index + 1, sum + numbers[index]);
    }
}