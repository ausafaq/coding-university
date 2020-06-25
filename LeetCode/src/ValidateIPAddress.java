import java.util.Arrays;

public class ValidateIPAddress {

    public static String validateIPAddress(String IP) {
        if(isIPv4(IP)) {
            return "IPv4";
        } else if(isIPv6(IP)) {
            return "IPv6";
        }
        return "Neither";
    }

    private static boolean isIPv4(String ip) {
        String[] nums = ip.split("\\.", -1);
        if(nums.length != 4) {
            return false;
        }
        for(String num : nums) {
            try {
                if(Integer.parseInt(num) > 255 || num.charAt(0) == '-' || (num.charAt(0) == '0' && num.length() != 1)) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    private static boolean isIPv6(String ip) {
        String[] nums = ip.split(":", -1);
        System.out.println(Arrays.toString(nums));
        if(nums.length != 8) {
            return false;
        }
        for(String num : nums) {
            try {
                if(Integer.parseInt(num, 16) > 65535 || num.charAt(0) == '-' || num.length() == 0 || num.length() > 4) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String address = "2001:0db8:85a3:0:0:8A2E:0370:7334:";
        System.out.println(validateIPAddress(address));
    }
}
