import java.util.*;

public class Main {
	public static void main(String[] args){
		String t = new Scanner(System.in).nextLine();
		for (int i=97; i<123; i++)
			System.out.print(t.indexOf(i) + " ");
	}
}