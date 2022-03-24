import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder[] sb = new StringBuilder[201];
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<201; i++)
			sb[i] = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			sb[age].append(age + " " + st.nextToken()+"\n");
		}
		
		StringBuilder print = new StringBuilder();
		for(StringBuilder i:sb)
			print.append(i);
		
		System.out.print(print);
	}
}