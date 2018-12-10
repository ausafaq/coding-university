public class ReverseBits {

    public static int reverseBits(int num) {
        String op = String.format("%32s", Integer.toBinaryString(num)).replace(' ', '0');
        //System.out.println(op);
        op = new StringBuilder(op).reverse().toString();
        int reversedNum = Integer.parseUnsignedInt(op,2);
        return reversedNum;
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(43261596));
    }
}
