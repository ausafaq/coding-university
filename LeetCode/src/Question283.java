public class Question283 {

    public void moveZeroes(int[] num) {

        for(int i = 0; i < num.length; i++) {
            if(num[i] == 0) {
                for(int j = i; j < num.length; j++) {
                    int temp = num[j];
                    num[j] = num[j+1];
                    num[j+1] = temp;
                }
            }
        }

        for(int x : num) {
            System.out.println(x + " ");
        }

    }

    public static void main(String[] args) {
        int[] input = {0,1,0,3,12};
    }
}
