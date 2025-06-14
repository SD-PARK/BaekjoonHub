import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static final int SET_SIZE = 20;
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int bitSet;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int cmdCount = Integer.parseInt(reader.readLine());
        bitSet = 0;

        for (int i=0; i<cmdCount; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            String operation = tokenizer.nextToken();
            int x = (tokenizer.hasMoreTokens()) ? Integer.parseInt(tokenizer.nextToken()) : 0;
            executeCommand(operation, x);
        }

        writer.flush();
    }

    private static void executeCommand(String operation, int x) throws IOException {
        switch(operation) {
            case "add":
                bitSet |= (1 << (x - 1));
                break;
            case "remove":
                bitSet &= ~(1 << (x - 1));
                break;
            case "check":
                char flag = ((bitSet & (1 << (x - 1))) != 0) ? '1' : '0';
                writer.append(flag).append("\n");
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