import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			String str = br.readLine() + "\n";
			Stack<Character> s = new Stack<>();
			
			for(char ch:str.toCharArray()) {
				if(ch != ' ' && ch != '\n')
					s.push(ch);
				else {
					while(!s.empty()) {
						bw.write(s.pop());
					}
					bw.write(ch);
				}
			}
		}
		bw.flush();
	}
}