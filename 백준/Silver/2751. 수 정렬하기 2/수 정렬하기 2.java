import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		boolean[] n = new boolean[2000001];
		for(int i=Integer.parseInt(br.readLine()); i>0; i--)
			n[Integer.parseInt(br.readLine())+1000000] = true;
		
		for (int i=0; i<n.length; i++)
			sb.append(n[i]==true?i-1000000+"\n":"");
		
		System.out.print(sb);
	}
}