public class ValidIPAddress {


    public String validIPAddress(String IP) {
        if (IP.contains("."))
            return checkV4(IP);
        else if(IP.contains(":"))
            return checkV6(IP);
        else
            return "Neither";
    }
    public String checkV4(String IP) {
        if(IP.charAt(0) == '.' || IP.charAt(IP.length()-1) == '.')
            return "Neither";
        String[] arr = IP.split("\\.");
        if(arr.length != 4)
            return "Neither";
        for(String block: arr) {
            if(block.length() < 1)
                return "Neither";
            if(block.contains("-"))
                return "Neither";
            if(block.charAt(0) == '0' && block.length() > 1)
                return "Neither";
            try {
                int b = Integer.parseInt(block);
                if(b < 0 || b > 255)
                    return "Neither";
            }
            catch(NumberFormatException e) {
                return "Neither";
            }
        }
        return "IPv4";
    }
    public String checkV6(String IP) {
        if(IP.charAt(0) == ':' || IP.charAt(IP.length()-1) == ':')
            return "Neither";
        String[] arr = IP.split(":");
        if(arr.length != 8)
            return "Neither";
        for(String block: arr) {
            if(block.length() > 4 || block.length() < 1)
                return "Neither";
            if(block.contains("-"))
                return "Neither";
            try {
                int decimal = Integer.parseInt(block,16);
            }
            catch(NumberFormatException e) {
                return "Neither";
            }
        }
        return "IPv6";
    }
}
