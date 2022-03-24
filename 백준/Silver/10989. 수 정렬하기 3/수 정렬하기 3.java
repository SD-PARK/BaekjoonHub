import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] arr = new int[10001];
		for(int i=Integer.parseInt(br.readLine()); i>0; i--)
			arr[Integer.parseInt(br.readLine())]++;
		
		for(int i=0; i<10001; i++)
			while(arr[i]-->0)
				sb.append(i+"\n");
		
		System.out.print(sb);
		br.close();
	}
}