import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for (int i = scan.nextInt(); i > 0; i--) {
			int dis = Math.abs(scan.nextInt() - scan.nextInt()), max = (int)Math.sqrt(dis);

			if(max == Math.sqrt(dis))
				System.out.println(max * 2 - 1);
			else if(dis <= max * max + max)
				System.out.println(max * 2);
			else
				System.out.println(max * 2 + 1);
			
		}
	}
}