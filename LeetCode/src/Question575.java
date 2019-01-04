import java.util.*;

public class Question575 {

    public static int distributeCandies(int[] candies) {

        Set<Integer> uniqueCandies = new HashSet<Integer>();

        for (int candy : candies) {
            uniqueCandies.add(candy);
        }

        return Math.min(uniqueCandies.size(), candies.length / 2);

    }

    public static void main(String[] args) {
        int[] input = {1, 1, 2, 2, 3, 3};
        System.out.println(distributeCandies(input));
    }
}
