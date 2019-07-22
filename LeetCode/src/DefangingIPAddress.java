public class DefangingIPAddress {
    public static String defangIPAdress(String address) {
        StringBuilder sb = new StringBuilder();
        char[] arr = address.toCharArray();
        char left = '[';
        char right = ']';
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != '.') {
                sb.append(arr[i]);
            } else {
                sb.append(left);
                sb.append(arr[i]);
                sb.append(right);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(defangIPAdress("1.1.1.1"));
    }
}
