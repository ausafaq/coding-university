public class ValidPerfectSquare {

    /**
     * Binary Search Implementation
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public static boolean isPerfectSquare(int num) {
        if(num < 2) {
            return true;
        }

        long left = 2, right = num / 2, guessSquared = 0;

        while(left <= right) {
            long x = left + (right - left) / 2;
            guessSquared = x * x;
            if(guessSquared == num) {
                return true;
            }
            if(guessSquared < num) {
                left = x + 1;
            } else {
                right = x - 1;
            }
        }
        return false;
    }

    /**
     * Newton's Algorithm
     * x2 = (x1 + num/x1) / 2
     */
    public static boolean isPerfectSquareNewtons(int num) {
        if(num < 2) {
            return true;
        }
        long x = num / 2;
        while(x * x > num) {
            x = (x + num/x) / 2;
        }
        return (x*x == num);
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(64));
        System.out.println(isPerfectSquareNewtons(64));
    }
}
