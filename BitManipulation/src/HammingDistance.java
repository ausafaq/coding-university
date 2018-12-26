public class HammingDistance {

    public static int hammingDistance(int n1, int n2) {
        return Integer.bitCount(n1 ^ n2);

    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
    }
}
