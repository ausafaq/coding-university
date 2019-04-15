public class AddDigits {

    public static int addDigits(int num) {

        if(num < 10) {
            return num;
        } else {
            int sum = 0;
            while(num != 0) {
                sum = sum + num%10;
                num = num/10;
            }
            num = sum;
        }
        return addDigits(num);
    }

    public static void main(String[] args) {
        System.out.println(addDigits(38));
    }
}
