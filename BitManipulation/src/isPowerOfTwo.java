public class isPowerOfTwo {

    public static boolean isPowerOfTwo(int num) {
        //Power of 4 will have a single bit
        //Zeros after the 1 bit will be multiple of four
        return (Integer.bitCount(num) == 1);
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(64));
    }
}
