import java.util.Scanner;

public class HalfDiamond {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int i, j;

        for (i = 1; i <= n; i++) {
            for (j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
        for (i = n; i >= 1; i--) {
            for (j = 1; j < i; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
