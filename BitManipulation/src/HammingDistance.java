public class HammingDistance {

    public static int hammingDistance(int n1, int n2) {
        return Integer.bitCount(x ^ y);

    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
    }
}
