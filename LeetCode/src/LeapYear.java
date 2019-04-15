public class LeapYear {

    public static boolean isCheckYear(int year) {

        // If a year is a multiple of 400
        // then it is a leap year
        if(year % 400 == 0)
            return true;

        // Else if a year is divisible by 100
        // then not a leap year
        else if(year % 100 == 0)
            return false;

        // Else if divisible by 4
        // then a leap year
        else if(year % 4 == 0)
            return true;

        return false;
    }

    public static void main(String[] args) {

        System.out.println(isCheckYear(2016));
    }
}
