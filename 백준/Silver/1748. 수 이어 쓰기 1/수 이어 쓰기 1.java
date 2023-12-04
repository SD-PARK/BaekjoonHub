import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int start = 1, end, len = 1;
        int digit = 0;

        while (start <= n) {
            end = (start * 10) - 1;
            if (end > n)
                end = n;

            digit += (end - (start - 1)) * len;

            start *= 10;
            len++;
        }

        System.out.print(digit);
    }
}