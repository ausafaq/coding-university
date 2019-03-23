import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class FizzBuzz {

    public static List<String> fizzBuzz(int n) {

        List<String> result =  new ArrayList<String>();

        for(int i = 1; i <= n; i++) {
            if((i  % 3 == 0) && (i % 5) == 0) {
                result.add("FizzBuzz");
            } else if(i % 3 == 0) {
                result.add("Fizz");
            } else if(i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(Integer.toString(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(fizzBuzz(15));
    }
}
