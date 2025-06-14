import java.util.Scanner;

public class Main {
    static int[] seq;
    static int seqLength;
    static boolean[] used;
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();

        seq = new int[m];
        seqLength = m;
        used = new boolean[n+1];

        backtrack(0, n);

        System.out.print(output);
    }

    public static void backtrack(int depth, int maxNumber) {
        for(int i=1; i<=maxNumber; i++) {
            if (used[i]) continue;

            seq[depth] = i;
            used[i] = true;

            if (depth + 1 == seqLength) {
                writeSequence();
            } else {
                backtrack(depth + 1, maxNumber);
            }

            used[i] = false;
        }
    }

    public static void writeSequence() {
        for (int num: seq)
            output.append(num).append(" ");
        output.append("\n");
    }
}