import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] st = br.readLine().split(" ");
		int N = Integer.parseInt(st[0]);
		int K = Integer.parseInt(st[1]);
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=N; i++)
			q.offer(i);
		
		bw.write("<");
		for(int i=0; i<N-1; i++) {
			for(int j=0; j<K-1; j++)
				q.offer(q.poll());
			bw.write(q.poll() + ", ");
		}
		bw.write(q.poll() + ">");
		
		bw.flush();
	}
}