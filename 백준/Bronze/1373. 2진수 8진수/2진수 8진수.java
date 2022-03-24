import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		String n = sc.nextLine();
		int len = n.length();
		
		while(len%3>0) {
			n = "0" + n;
			len++;
		}
		
		for(int i=0; i<len; i+=3)
			sb.append((n.charAt(i)-'0')*4 + (n.charAt(i+1)-'0')*2 + (n.charAt(i+2)-'0'));
		
		System.out.print(sb);
	}
}