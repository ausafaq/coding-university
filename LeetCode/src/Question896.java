public class Question896 {

    public static boolean isMonotonic(int[] A) {

        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1])
                increasing = false;
            if (A[i] < A[i + 1])
                decreasing = false;
        }

        return increasing || decreasing;
    }


    public static void main(String[] args) {
        int[] input = {1, 1, 0};

        System.out.println(isMonotonic(input));

    }
}
