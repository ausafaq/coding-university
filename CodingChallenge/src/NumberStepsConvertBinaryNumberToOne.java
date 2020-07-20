public class NumberStepsConvertBinaryNumberToOne {

    public int calculateSteps(String num) {
        if(num.length() == 1) {
            return 0;
        }

        int count = 0;
        char[] arr = num.toCharArray();
        for(int i = num.length() - 1; i > 0; i--) {
            if(arr[i] == '0') {
                count++;
                i--;
            } else {
                count++;
                while(arr[i] == '1' && i > 0) {
                    count++;
                    i--;
                }
                if(i == 0) count++;
                arr[i] = '1';
            }
        }
        return count;
    }
}
