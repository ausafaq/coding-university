public class IsPowerOfFour {

    //Use log identity of bit manipulation

    public static boolean isPowerOfFour(int num) {
        //Power of 4 will have a single bit
        //Zeros after the 1 bit will be multiple of four
        return (Integer.bitCount(num) == 1 && (Integer.toBinaryString(num).length() - 1)%2 == 0);
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(64));
    }
}
