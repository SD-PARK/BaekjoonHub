import java.util.*;

class Main {
	public static void main(String[] args) {
		int N = new Scanner(System.in).nextInt(), i = 665;
		while (N > 0) {
			i++;
			if (Integer.toString(i).indexOf("666") != -1)
				N--;
		}
		System.out.print(i);
	}
}