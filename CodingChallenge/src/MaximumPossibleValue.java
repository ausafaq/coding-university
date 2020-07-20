import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaximumPossibleValue {

    public static int maximumPossibleValue(int N) {
        if(N == 0) {
            return 50;
        }
        List<Integer> list = new ArrayList<>();
        boolean isPositive = N > 0;
        N = Math.abs(N);
        while(N > 0) {
            list.add(N % 10);
            N /= 10;
        }
        int k = 0;
        boolean isAdded = false;
        for(int i = list.size() - 1; i >= 0; i--) {
            if(isPositive) {
                if(!isAdded && list.get(i) < 5) {
                    k = k * 10 + 5;
                    isAdded = true;
                }
            } else {
                if(!isAdded && list.get(i) > 5) {
                    k = k * 10 + 5;
                    isAdded = true;
                }
            }
            k = k * 10 + list.get(i);
        }
        if(!isAdded) k = k * 10 + 5;
        return k * (isPositive ? 1 : -1);
    }

    public static void main(String[] args) {
        System.out.println(maximumPossibleValue(268));
        System.out.println(maximumPossibleValue(-999));
        System.out.println(maximumPossibleValue(670));
    }
}
