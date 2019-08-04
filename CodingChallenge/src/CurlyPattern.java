import java.util.Scanner;

public class CurlyPattern {

    public static void curlyPattern(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print('{');
            }

            for (int j = 1; j <= i; j++) {
                System.out.print('}');
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int input = sc.nextInt();
        curlyPattern(input);
    }
}
