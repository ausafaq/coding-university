public class Question922 {

    public static int[] sortArrayByParityII(int[] A) {

        int len = A.length;
        int[] result = new int[len];

        int evenPtr = 0;
        for(int x : A) {
            if(x % 2 == 0) {
                result[evenPtr] = x;
                evenPtr += 2;
            }
        }

        int oddPtr = 1;
        for(int x : A) {
            if(x % 2 == 1) {
                result[oddPtr] = x;
                oddPtr += 2;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] input = {4,2,5,7};
        int[] result = sortArrayByParityII(input);

        for(int num : result) {
            System.out.print(num + " ");
        }
    }
}
