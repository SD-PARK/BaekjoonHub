import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final int SET_SIZE = 20;
    private static final StringBuilder stringBuilder = new StringBuilder();

    private static int bitSet;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(reader.readLine());
        bitSet = 0;

        for (int i=0; i<m; i++) {
            executeCommand(reader.readLine().split("\\s+"));
        }

        System.out.println(stringBuilder);
    }

    private static void executeCommand(String[] cmd) {
        String operation = cmd[0];
        int x = (cmd.length >= 2) ? Integer.parseInt(cmd[1]) : 0;

        switch(operation) {
            case "add":
                bitSet |= (1 << (x - 1));
                break;
            case "remove":
                bitSet &= ~(1 << (x - 1));
                break;
            case "check":
                int is = ((bitSet & (1 << (x - 1))) != 0) ? 1 : 0;
                stringBuilder.append(is).append("\n");
                break;
            case "toggle":
                bitSet ^= (1 << (x - 1));
                break;
            case "all":
                bitSet = (1 << SET_SIZE) - 1;
                break;
            case "empty":
                bitSet = 0;
                break;
        }
    }
}