import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		ArrayList<Character> al = new ArrayList<Character>();
		for (int i = N; i > 0; i--) {
			al.clear();
			String T = scan.next();
			al.add(T.charAt(0));
			for (char c : T.toCharArray()) {
				if (c != al.get(al.size() - 1)) {
					// 조사
					boolean f = false;
					for (char d : al) {
						if (d == c)
						{
							N--;
							f = true;
						}
					}
					if (f == true)
						break;
					else
						al.add(c);
				}
			}
		}
		System.out.print(N);
	}
}