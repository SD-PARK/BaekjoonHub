import java.io.*;

public class Main {
    private static final int SET_SIZE = 20;
    private static final WriteHandler writer = new WriteHandler(System.out);

    private static int bitSet;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int cmdCount = Integer.parseInt(reader.readLine());
        bitSet = 0;

        for (int i=0; i<cmdCount; i++) {
            String[] cmd = reader.readLine().split("\\s+");
            executeCommand(cmd);
        }

        writer.flush();
    }

    private static void executeCommand(String[] cmd) throws IOException {
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
                writer.appendLine(is);
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

class WriteHandler {
    private final BufferedWriter writer;

    public WriteHandler(OutputStream out) {
        writer = new BufferedWriter(new OutputStreamWriter(out));
    }

    public void appendLine(int num) throws IOException {
        writer.append(Integer.toString(num)).append("\n");
    }

    public void flush() throws IOException {
        writer.flush();
    }
}