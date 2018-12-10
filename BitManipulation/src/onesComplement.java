public class onesComplement {

    public static int onesComplement(int num) {
        return (~num + (Integer.highestOneBit(num) << 1));
    }

    public static void main(String[] args) {
        System.out.println(onesComplement(5));
    }
}
