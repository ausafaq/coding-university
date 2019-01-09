public class BubbleSort {

    public static void bubbleSort(int[] input) {

        for(int i = 0; i < input.length; i++) {
            for(int j = 0; j < input.length - i - 1; j++) {
                if(input[j] > input[j+1]) {
                    int temp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = temp;
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] input = {20, 35, -15, 7, 55, 1, -22};

        bubbleSort(input);

        for(int num : input) {
            System.out.print(num + " ");
        }
    }
}
