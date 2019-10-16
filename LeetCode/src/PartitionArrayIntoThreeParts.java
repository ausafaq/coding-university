public class PartitionArrayIntoThreeParts {

    public static boolean canThreePartsEqualSum(int[] A) {
        int total = 0;
        for(int a : A) {
            total += a;
        }

        int n = total / 3;

        int tempSum = 0;
        int count = 0;

        for(int i = 0; i < A.length; i++) {
            tempSum += A[i];
            if(tempSum == n) {
                tempSum = 0;
                count++;
            }
        }
        return count==3;
    }


    public static void main(String[] args) {
        int[] input = {0,2,1,-6,6,-7,9,1,2,0,1};
        System.out.println(input);
    }
}
