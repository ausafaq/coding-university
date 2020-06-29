public class AddBinaryStrings {

    public String addBinary(String a, String b) {
        return Integer.toBinaryString((Integer.parseInt(a, 2) + Integer.parseInt(b, 2)));
    }

    public String addBinaryII(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int p1 = a.length() - 1, p2 = b.length() - 1, carry = 0;
        while(p1 >= 0 || p2 >= 0) {
            int sum = carry;
            if (p1 >= 0) sum += a.charAt(p1) - '0';
            if (p2 >= 0) sum += b.charAt(p2) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if(carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}
