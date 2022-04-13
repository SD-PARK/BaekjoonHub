import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Integer> st = new Stack<>();
		String[] str;
		int N = Integer.parseInt(br.readLine());
		while (N-- > 0) {
			str = br.readLine().split(" ");
			switch (str[0]) {
			case "push":
				st.push(Integer.parseInt(str[1]));
				break;
			case "pop":
				bw.write(st.isEmpty() ? -1 + "\n" : st.pop() + "\n");
				break;
			case "size":
				bw.write(st.size() + "\n");
				break;
			case "empty":
				bw.write(st.isEmpty() ? 1 + "\n" : 0 + "\n");
				break;
			case "top":
				bw.write(st.isEmpty() ? -1 + "\n" : st.peek() + "\n");
				break;
			}
		}
		bw.close();
	}
}