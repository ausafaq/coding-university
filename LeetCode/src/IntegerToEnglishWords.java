public class IntegerToEnglishWords {


//    public static String one(int num) {
//        switch (num) {
//            case 1: return "One";
//            case 2: return "Two";
//            case 3: return "Three";
//            case 4: return "Four";
//            case 5: return "Five";
//            case 6: return "Six";
//            case 7: return "Seven";
//            case 8: return "Eight";
//            case 9: return "Nine";
//        }
//        return "";
//    }
//
//    public static String twoLessThan20(int num) {
//        switch (num) {
//            case 10: return "Ten";
//            case 11: return "Eleven";
//            case 12: return "Twelve";
//            case 13: return "Thirteen";
//            case 14: return "Fourteen";
//            case 15: return "Fifteen";
//            case 16: return "Sixteen";
//            case 17: return "Seventeen";
//            case 18: return "Eighteen";
//            case 19: return "Nineteen";
//        }
//        return "";
//    }
//
//    public static String ten(int num) {
//        switch(num) {
//            case 2: return "Twenty";
//            case 3: return "Thirty";
//            case 4: return "Forty";
//            case 5: return "Fifty";
//            case 6: return "Sixty";
//            case 7: return "Seventy";
//            case 8: return "Eighty";
//            case 9: return "Ninety";
//        }
//        return "";
//    }


    private static final String[] ONE = {"", "One", "Two", "Three", "Four", "Five",
            "Six", "Seven", "Eight", "Nine"};
    private static final String[] TWO_LESS_THAN_20 = {"", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
            "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] TEN = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public static String two(int num) {
        if(num == 0) {
            return "";
        } else if(num < 10) {
            return ONE[num];
        } else if(num < 20) {
            return TWO_LESS_THAN_20[num];
        } else {
            int tens = num / 10;
            int unit = num % 10;
            if(unit != 0) {
                return TEN[tens] + " " + ONE[unit];
            } else {
                return TEN[tens];
            }
        }
    }

    public static String three(int num) {
        int hundred = num / 100;
        int tens = num % 100;
        String res = "";
        if(hundred * tens != 0) {
            res = ONE[hundred] + " Hundred " + two(tens);
        } else if ((hundred != 0) && (tens == 0)) {
            res = ONE[hundred] + " Hundred";
        } else if ((hundred == 0) && (tens != 0)) {
            res = two(tens);
        }
        return res;
    }

    public static String numToWords(int num) {
        if(num == 0) {
            return "Zero";
        }

        int billion = num / 1000000000;
        int million = (num - (billion * 1000000000)) / 1000000;
        int thousand = (num - (billion * 1000000000) - (million * 1000000)) / 1000;
        int rest = num - (billion * 1000000000) - (million * 1000000) - (thousand * 1000);

        String result = "";
        if(billion != 0) {
            result = three(billion) + " Billion";
        }
        if(million != 0) {
            result += " ";
            result += three(million) + " Million";
        }
        if(thousand != 0) {
            if(!result.isEmpty()) {
                result += " ";
            }
            result += three(thousand) + " Thousand";
        }
        if(rest != 0) {
            if(!result.isEmpty()) {
                result += " ";
            }
            result += three(rest);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(numToWords(1234567890));
    }
}


