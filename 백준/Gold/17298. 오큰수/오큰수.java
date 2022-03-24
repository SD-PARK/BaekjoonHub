import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String[] a = br.readLine().split(" ");
		int[] A = new int[N];
		int[] NGE = new int[N];
		Stack<Integer> s = new Stack<>();
		
		for(int i=0; i<N; i++)
			A[i] = Integer.parseInt(a[i]);
		
		for(int i=0; i<N; i++) {
			while(!s.isEmpty() && A[i] > A[s.peek()]) {
				NGE[s.peek()] = A[i];
				s.pop();
			}
			s.push(i);
		}
		
		while(!s.isEmpty())
			NGE[s.pop()] = -1;
		
		for(int i:NGE)
			bw.write(i + " ");
		
		bw.flush();
	}
}