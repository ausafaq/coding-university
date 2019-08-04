import java.util.Scanner;

public class CurlyPattern {

    public static void curlyPattern(int n) {
        for(int i = 1; i <= n; i++) {
            printLeft(i);
            printRight(i);
        }

    }

    public static void printLeft(int n) {
        for(int i = 1; i <= n; i++) {
            System.out.print('{');
        }
    }

    public static void printRight(int n) {
        for(int i = 1; i <= n; i++) {
            System.out.print('}');
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int input = sc.nextInt();
        curlyPattern(input);
    }
}
