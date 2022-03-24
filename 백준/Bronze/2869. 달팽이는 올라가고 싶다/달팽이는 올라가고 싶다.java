import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken()), B = A - Integer.parseInt(st.nextToken());
		long V = Long.parseLong(st.nextToken()) - A;
		V = (V % B) > 0 ? V / B + 2 : V / B + 1;
		System.out.print(V);
	}
}