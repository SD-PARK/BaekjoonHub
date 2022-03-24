import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wt = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = Integer.parseInt(rd.readLine()); i > 0; i--) {
			StringTokenizer st = new StringTokenizer(rd.readLine());
			wt.write((Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())) + "\n");
		}
		wt.close();
	}
}