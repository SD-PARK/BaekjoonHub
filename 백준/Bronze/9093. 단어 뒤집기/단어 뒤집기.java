import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> st = new Stack<>();

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            String text = br.readLine();
            int textLength = text.length();
            for (int i=0; i<textLength; i++) {
                char ch = text.charAt(i);
                if (ch == ' ') {
                    while(!st.isEmpty())
                        bw.write(st.pop());
                    bw.write(' ');
                } else {
                    st.push(ch);
                }
            }
            while(!st.isEmpty())
                bw.write(st.pop());
            bw.write('\n');
        }
        bw.close();
    }
}