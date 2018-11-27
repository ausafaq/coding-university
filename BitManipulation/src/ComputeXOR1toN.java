// Java program to find XOR of numbers
// from 1 to n.

public class ComputeXOR1toN {

    public static int computerXOR(int n) {
        // if n is a multiple of 4
        if (n % 4 == 0) {
            return n;
        }

        // if n% 4 is 1
        if (n % 4 == 1) {
            return 1;
        }

        // if n%4 gives 1
        if (n % 4 == 2) {
            return n + 1;
        }

        // if n%4 gives 3
        return 0;
    }

    public static void main(String[] args) {
        int n = 3;

        System.out.println(computerXOR(n));
    }
}
