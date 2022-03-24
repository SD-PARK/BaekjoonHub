import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] arr = new int[10];
		int N = Integer.parseInt(br.readLine());
		
		do {
			arr[N%10]++;
		} while((N/=10) != 0);
		
		for(int i=9; i>=0; i--)
			while(arr[i]-->0)
				sb.append(i);
		
		System.out.print(sb);
	}
}